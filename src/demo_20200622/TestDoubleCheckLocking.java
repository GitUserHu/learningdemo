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
		// 当线程A进入到此方法执行到创建实例，然而创建实例不是原子操作（创建对象有3个步骤：1、分配内存 2、初始化对象数据比如成员数据 3、将引用与对象内存建立连接）
		// 创建对象的3个步骤中，如果步骤2和步骤3发生了指令重排序，就会导致对象未初始化完全。此时线程B进入方法，判断instance是否为空。此时instance并不为空，
		// 导致线程B使用一个未完全初始化的对象，导致安全性问题。解决该问题的办法就是给instance加上violate关键字，禁止指令重排序。
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
