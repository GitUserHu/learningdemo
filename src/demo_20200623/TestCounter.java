package demo_20200623;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class TestCounter {
	private static final int SIZE = 1000;
	
	public static void main(String[] args) throws InterruptedException {
		simulateVote();
		
		  ThreadPoolExecutor threadPool = new ThreadPoolExecutor(SIZE, SIZE, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()); 
		  CountDownLatch latch = new CountDownLatch(SIZE); 
		  for (int i = 0; i< SIZE; i++) {
			  threadPool.execute(()->{ 
				  CounterWithAtomicInteger.add(); 
				  latch.countDown();
			  }); 
		  } 
		  latch.await(); 
		  System.out.println(CounterWithAtomicInteger.get());
		  threadPool.shutdown();
		 
	}
	
	public static void simulateVote() throws InterruptedException {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(SIZE, SIZE, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		CountDownLatch latch = new CountDownLatch(SIZE);
		List<Participant> participants = new ArrayList<>();
		for (int j = 0; j < 10; j++) {
			participants.add(new Participant(String.valueOf(j)));
		}
		for (int i = 0; i< SIZE; i++) {
			threadPool.execute(()->{
				
				int participantNo = ThreadLocalRandom.current().nextInt(10);
				participants.get(participantNo).getVote();
				latch.countDown();
			});
		}
		latch.await();
		int total = 0;
		for (Participant participant : participants) {
			int totalVotes = participant.totalVotes();
			System.out.printf("Participant [%s] get [%d] votes \n", participant.getName(), totalVotes);
			total+= totalVotes;
		}
		System.out.println(total);
		threadPool.shutdown();
	}
}

class Participant {
	private String name;
	
	private Counter counter = new Counter();
	
	public Participant(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void getVote() {
		counter.add();
	}
	
	public int totalVotes() {
		return counter.get();
	}
}

class Counter {
	private AtomicInteger COUNTER = new AtomicInteger();
	public void add() {
		 COUNTER.addAndGet(1);
	}
	public int get() {
		return COUNTER.get();
	}
}

class CounterWithAtomicInteger {
	private static final AtomicInteger COUNTER = new AtomicInteger();
	
	public static void add() {
		 COUNTER.addAndGet(1);
	}
	public static int get() {
		return COUNTER.get();
	}
}

class CounterWithLongAdder {
	LongAdder adder = new LongAdder();
	public void add() {
		adder.add(1);
	}
}
