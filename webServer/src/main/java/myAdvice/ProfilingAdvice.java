package myAdvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {

	public void printStr(JoinPoint joinPoint, Object ret) throws Throwable{
		String signatureString = joinPoint.getSignature().toShortString();
		
		System.out.println(signatureString + "---advice---"+ (String) ret);
	}
	
	
	//이 메서드는 around advice용
	// ProceedingJoinPoint : 대상 객체 정보 클래스
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + " start");
		
		long start = System.currentTimeMillis();
		
		try {
			// 대상 메서드 호출
			Object result = joinPoint.proceed();
			return result;
		} finally{
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " finish");
			System.out.println(signatureString + " run time: "+ (finish - start) + "ms");
		}
		
	}
	
}

/*aspectjrt
aspectjweaver
aspectjtools*/
