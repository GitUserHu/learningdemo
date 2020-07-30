package demo_20200622;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch {
	public static final int SIZE = 10;
	public static final CountDownLatch countDown = new CountDownLatch(SIZE);
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Runtime.getRuntime().availableProcessors());
		 long start = System.currentTimeMillis();
		testCountDown();
		System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
	}
	

	
	public static void testCountDown() throws InterruptedException {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(SIZE, SIZE, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10));
		for (int i = 0; i< SIZE; i++) {
			threadPoolExecutor.execute(()->{
				 long start = System.currentTimeMillis();
					try {
						
					        Thread.sleep(3000);
					        
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("task is running");
					System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
					countDown.countDown();
				
			});
		}
		countDown.await();
		System.out.println("count down finished...");
		threadPoolExecutor.shutdown();
	}

}
