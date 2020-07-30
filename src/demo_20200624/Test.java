package demo_20200624;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	private static volatile int repositoryCap = 1;
	private static final int SIZE = 1000;
	static Object lock = new Object();
	public static void main(String[] args) throws InterruptedException {
		// test();
		award();

	}
	
	public static void test() {
		Integer a = 1;
		Integer b = 2;
		Integer c = null;
		boolean flag = false;
		Integer result = flag? a+b : c;
	}
	
	public static void award() throws InterruptedException {
		// CountDownLatch countDownLatch = new CountDownLatch(SIZE);
		
		for (int i = 0; i < SIZE; i++) {
			new Thread(()->{
					getAward();
				
			}) .start();

		}
		//Thread.sleep(2000);
		System.out.println("award finished.");
		System.out.println(repositoryCap);
	}
	
	public static void getAward() {
		if (repositoryCap <= 0) return;
		synchronized (lock) {
			if (repositoryCap <= 0) return;
			repositoryCap--;
			System.out.println(Thread.currentThread().getName()+ " get 1 award");
			
		}
		
	}
	
}
