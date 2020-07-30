package demo_20200618;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class TestThreadPool {

	public static void main(String[] args) {
		// ，这种方式创建的线程池允许创建的线程数为Integer.MAX_VALUE，可能会创建大量的线程，从而导致内存溢出。
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		
		// ，自定义创建方式
		// ，构建SynchronousQueue的参数fair表示创建的同步队列是公平的还是不公平的，true则使用FIFO规则的队列(Queue)，false则使用栈(Stack)
		// public SynchronousQueue(boolean fair) {
	    //     transferer = fair ? new TransferQueue<E>() : new TransferStack<E>();
	    // }
		ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(true));
		
		// #2 start
		// ， 这种方式创建的线程池对应的任务队列的容量是Integer.MAX_VALUE，可能会堆积大量的任务，导致内存溢出
		// Executors.newFixedThreadPool()和Executors.newSingleThreadExecutor()对应创建的固定线程数的线程池和单个线程的线程池所用的队列都是
		// new LinkedBlockingQueue<Runnable>().这种方式的任务队列没有指定任务队列的容量，使用默认的容量Integer.MAX_VALUE
		// public LinkedBlockingQueue() {
	    //   this(Integer.MAX_VALUE);
	    // }
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		// #2 end
		
		
		//，使用ThreadPoolExecutor自定义创建线程池的参数
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1000));	
		// ThreadPoolExecutor.subimt()方法和ThreadPoolExecutor.execute()区别
		// submit()方法是ThreadPoolExecutor父类AbstractExecutorService中实现的， 最后都会调用到AbstractExecutorService的实现类中的execute()方法
		// execute()方法是ThreadPoolExecutor实现的
		// submit()有返回值 Future，所以submit()方法执行任务是异步的
		// execute()没有返回值，不是异步的。
		Future<?> submit = threadPoolExecutor.submit(()->{
			
		});
		threadPoolExecutor.execute(()->{
			
		});
		
		
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(10);
		newScheduledThreadPool.execute(()->{
			
		});
		
		

	}

}
