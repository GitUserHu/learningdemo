package demo_20200630;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadLocal {
	static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
	static final String PATTERN2 = "yyyy-MM-dd hh:mm:ss";
	static final int TASK_SIZE = 10000000;
	static final int THREAD_SIZE = 10;
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(THREAD_SIZE);
		
		for (int i = 0; i < TASK_SIZE; i++) {
			System.out.println(i);
			newFixedThreadPool.submit(()->{
				DateUtil.getMap(PATTERN);
				//DateUtil.remove();
				
			});
			
		}
		
		newFixedThreadPool.shutdown();
		System.out.println(DateUtil.getMap(PATTERN) == DateUtil.getMap(PATTERN2));
	}
}
