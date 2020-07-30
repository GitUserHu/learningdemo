package demo_20200619;

import java.util.Timer;
import java.util.TimerTask;

public class Test_Timer {

	public static void main(String[] args) {
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
		TimerTask timerTask1 = new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println("task 1 running start");
					//throw new Exception("exception 1");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println("task 1 running end");
					
				}	
			}
		};
		
		TimerTask timerTask2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println("task 2 running start");
				//int i = 10/0;
				System.out.println("task 2 running end");
			}
		};
		new Thread(()->{
			timer1.schedule(timerTask1, 1000L);
			//timer1.cancel();
		}).start();
		
		new Thread(()->{
			timer2.schedule(timerTask2, 1000L);
			//timer2.cancel();
		}).start();
		
		// testTimerTask();
		
		
	}
	
	
	
	
	public static void testTimerTask() {
		TimerTask timerTask1 = new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println("task 1 running start");
					throw new Exception("exception 1");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println("task 1 running end");
				}
				
				
			}
		};
		
		TimerTask timerTask2 = new TimerTask() {
			@Override
			public void run() {
				System.out.println("task 2 running start");
				//int i = 10/0;
				System.out.println("task 2 running end");
			}
		};
		Timer timer = new Timer();
		timer.schedule(timerTask2, 1000L);
		timer.schedule(timerTask1, 1000L);
	}
	
}
