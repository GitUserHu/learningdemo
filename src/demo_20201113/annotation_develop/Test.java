package demo_20201113.annotation_develop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo_20201113.annotation_develop.config.AppConfig;
import demo_20201113.annotation_develop.config.DBConfig;
import demo_20201113.annotation_develop.entity.Account;
import demo_20201113.annotation_develop.service.TestService;

public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("demo_20201113.annotation_develop");
		//TestService testService = (TestService) ctx.getBean("testServiceImpl");
		//testService.save(new Account());
		AppConfig appConfig = (AppConfig) ctx.getBean("appConfig");
		appConfig.show();
	}

}
