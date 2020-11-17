package demo_20201028;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanPostProcessor {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		Origin bean = (Origin)ctx.getBean("origin");
		bean.test();
	}

}
