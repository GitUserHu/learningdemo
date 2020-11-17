package demo_20201106.transaction;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo_20201106.transaction.config.DBConfig;
import demo_20201106.transaction.config.DBConnection;
import demo_20201106.transaction.config.DBProperty;
import demo_20201106.transaction.dao.AccountDAO;
import demo_20201106.transaction.entity.Account;
import demo_20201106.transaction.service.DemoService;
import demo_20201106.transaction.service.TestService;



public class Test {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("transaction-application.xml");
		//TestService testService = (TestService)ctx.getBean("testService");
		//Account account = new Account();
		//testService.save(account);
		DBProperty dbConfig = (DBProperty)ctx.getBean("DBProperty");
		//dbConfig.connect();
		DBConnection instance = DBConnection.getInstance();
		int threadCount = 1000;
		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		AtomicInteger count = new AtomicInteger(0);
		for (int i = 0; i < threadCount; i++) {
			new Thread(()->{
				if (DBConnection.getInstance() == instance) {
					count.incrementAndGet();
				}
				countDownLatch.countDown();	
			}).start();
		}
		countDownLatch.await();
		System.out.println(count.get()==threadCount);
	}

}
