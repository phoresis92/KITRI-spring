package test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	public static void main(String[] args) {
		
		String[] config = new String[] {"appConfig.xml"};
		//스프링 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
/*		System.out.println("t1==================================");
		Test t = (Test) context.getBean("t");
		System.out.println("str: "+t.str);
		System.out.println("num: "+t.num);
		t.test1();
		t.test2();
		t.test3();
		
		System.out.println("t2==================================");
		Test t2 = (Test) context.getBean("t2");
		System.out.println("str: "+t2.str);
		System.out.println("num: "+t2.num);

		System.out.println("t3==================================");
		Test t3 = (Test) context.getBean("t3");
		System.out.println("str: "+t3.str);
		System.out.println("num: "+t3.num);
		
		System.out.println("t4==================================");
		Test t4 = (Test) context.getBean("t4");
		System.out.println("str: "+t4.str);
		System.out.println("num: "+t4.num);*/
		
		//====================================================================
		
		Test2 t = (Test2) context.getBean("t2");
		Test t1 = t.getT1();
		System.out.println(t1.num);
		t1.test1();
		System.out.println(t);
		
		Test2 t3 = (Test2) context.getBean("t3");
		System.out.println(t3);
		
		
	}

}
