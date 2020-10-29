package demo_20201026;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringFactoryBean {

	@SuppressWarnings("resource")
	@Test
	void test1() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
		Object bean = ctx.getBean("");
		
	}
}
