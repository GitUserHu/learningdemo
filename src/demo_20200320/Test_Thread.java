package demo_20200320;

public class Test_Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lockStr = "Lock";
		Thread thread1 = new Thread(()->{
			synchronized (lockStr) {
				System.out.println("Thread1 starts running...");
				try {
					Thread.sleep(1000); // sleep方法放在同步代码块中时，不会释放对象锁
					lockStr.wait(); // Wait()方法会释放对象锁，其他在该对象锁上阻塞的线程会拿到这个对象锁，
					   				// ps: 当其他线程通过调用notify/notifyAll方法时，当前线程会重新获得锁，并执行
									
					System.out.println("continue to run...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread1 finished...");
			}
		});
		thread1.start();
		Thread thread2 = new Thread(()->{
			synchronized (lockStr) {
				System.out.println("Thread2 starts running...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread2 finished...");
				lockStr.notifyAll();
			}
		});
		thread2.start();
	}
	
}
