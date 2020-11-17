package demo_20201105.springmybatis;

import java.io.IOException;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo_20201105.springmybatis.dao.AccountDAO;
import demo_20201105.springmybatis.entity.Account;




public class Test {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-configuration.xml");
		AccountDAO bean = (AccountDAO)ctx.getBean("accountDAO");
		Account account = new Account();
		account.setUserName("tttt");
		bean.save(account);
		ctx.close();
		
	}

}
