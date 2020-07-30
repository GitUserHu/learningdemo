package demo_20200622;

import java.util.concurrent.atomic.AtomicReference;

public class TestDoubleCheckLocking {

	public static void main(String[] args) {
		

	}

	
}

class LazyInitDemoVolatile {
	private volatile Object instance = null;
	
	public Object getInstance() {
		if (instance == null) {
			synchronized (this) {
				if (instance == null) {
					instance = costlyIdempotentOperation();
				}
			}
		}
		return instance;
	}
	
	private Object costlyIdempotentOperation() {
		return new Object();
	}
} 

class LazyInitDemoAtomic {
	private AtomicReference<Object> instance = new AtomicReference<>();
	
	public Object getInstance() {
		while (instance.get() == null) {
			instance.compareAndSet(null, new Object());
		}
		return instance.get();
	}
}

class LazyInitDemoError {
	private Object instance = null;
	
	public Object getInstance() {
		// 当两个线程A,B同时进入此方法时， A线程先获取到当前的LazyInitDemoError对象的对象锁，然后初始化instance，A线程退出方法。
		// 此后B线程获取到LazyInitDemoError对象的对象锁，由于instance的值来自与B线程的本地缓冲，此时instance仍然为null。
		// 所以B线程仍然会执行初始化动作。
		if (instance == null) {
			synchronized (this) {
				if (instance == null) {
					instance = costlyIdempotentOperation();
				}
			}
		}
		return instance;
	}
	
	private Object costlyIdempotentOperation() {
		return new Object();
	}
}
