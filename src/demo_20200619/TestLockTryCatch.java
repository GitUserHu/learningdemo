package demo_20200619;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockTryCatch {
	//，非公平同步锁
	public static final Lock LOCK = new ReentrantLock();
	public static void main(String[] args) throws Exception {
		lockWithTry(); // 只有这一种方式能够成功的释放锁
		lockWithTryError1();
		lockWithTryError2();
	}
	//，在使用尝试机制来获取锁的方式中，进入业务代码块之前，必须先判断当前线程是否持有锁
	public static void tryLockBeforeDosomething() {
		boolean locked = LOCK.tryLock();
		if (locked) {
			try {
				doSomething();
				methodWillThrowException();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				LOCK.unlock();
				System.out.println("成功释放锁");
			}
		}
	}
	
	//】在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方法与try代码块之间没有任何可能抛出异常的方法调用。
	public static void lockWithTry() {
		LOCK.lock();
		try {
			doSomething();
			methodWillThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			LOCK.unlock();
			System.out.println("成功释放锁");
		}
	}
	// ，锁与try-catch配合使用的错误方式1
	public static void lockWithTryError1() throws Exception {
		LOCK.lock();
		methodWillThrowException();// 如果这里抛出了异常，那么，锁将不会解锁，所以其他线程无法获取到锁。
		try {
			doSomething();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			LOCK.unlock();
			System.out.println("成功释放锁");
		}
	}
	
	// ，锁与try-catch配合使用的错误方式2
	public static void lockWithTryError2() {
		try {
			methodWillThrowException(); // 这个方法抛出异常，那么该线程本来就没有获取该锁，导致在finally块中对未加锁的对象解锁，会抛出异常。
			LOCK.lock();
			doSomething();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			LOCK.unlock();
			System.out.println("成功释放锁");
		}
	}
	public static void methodWillThrowException() throws Exception {
		throw new Exception("Exception...");
	}
	public static void doSomething() {
		
	}

}
