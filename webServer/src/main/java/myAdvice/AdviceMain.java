package myAdvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceMain {

	public static void main(String[] args) {
		
		String[] config = new String[] {"appConfig.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		AdviceTest a = (AdviceTest) context.getBean("adviceTest");
		a.test1();
		a.test2();
		a.test3();
		
	}
	
}

/*aspectjrt
aspectjweaver
aspectjtools
*/

