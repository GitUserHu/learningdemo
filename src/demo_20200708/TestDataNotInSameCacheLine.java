package demo_20200708;

import java.util.concurrent.CountDownLatch;

public class TestDataNotInSameCacheLine {

	static long count = 1_0000_0000L;
	static long temp = 1L;
	public static void main(String[] args) throws InterruptedException {
		TestObj2[] array = new TestObj2[2];
		CountDownLatch countDownLatch = new CountDownLatch(2);
		array[0] = new TestObj2();
		array[1] = new TestObj2();
		Thread one = new Thread(()->{
			for (long i = 0; i < count; i++) {
				array[0].x = temp; 
			}
			countDownLatch.countDown();
		});
		Thread two = new Thread(()->{
			for (long i = 0; i < count; i++) {
				array[1].x = temp; 
			}
			countDownLatch.countDown();
		});
		long start = System.nanoTime();
		one.start();
		two.start();
		countDownLatch.await();
		long end = System.nanoTime();
		System.out.println((end-start)/100_0000);
	}

}
/**
 * 该类的任何对象的数据x无论如何都不会被分配在同一个CacheLine中
 * 这样设计的目的：数据在同一个CacheLine时（A.x和B.x被分配在同一个CacheLine中），当A.x变化时会通知所有使用到A.x所在的CacheLine的线程重新去内存中拿数据，本地的数据缓冲失效。
 * 				而数据不在同一个CacheLine时(A.x和B.x没有被分配在同一个CacheLine中)，
 * 				A.x变化时，由于B.x不和A.x在同一个CacheLine中，所以当其他线程中使用B.x时就不再从内存中读取，速度更快。
 * @author jiabing
 *
 */
class TestObj2{
	protected long p1, p2, p3, p4, p5, p6, p7; // cache line padding
	volatile long x;
	protected long p8, p9, p10, p11, p12, p13, p14; // cache line padding
}