package demo_20201102.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application2.xml");
		Origin bean = (Origin)ctx.getBean("origin");
		bean.test();
		ctx.close();
		
	}

}
