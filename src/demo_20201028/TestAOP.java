package demo_20201028;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/demo_20201028/application.xml");
		OriginObject bean = (OriginObject)ctx.getBean("origin");
	
		bean.test2("2", "1");
		bean.test3();
		
	}
}
