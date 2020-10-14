package demo_20200918;
/**
 *  LockEliminate - 锁消除
 *  LockCoarsen - 锁粗化
 */
import org.junit.jupiter.api.Test;

public class LockEliminateCoarsen {
	@Test
	public void testLockCoarsen(String str) {
		int i = 0;
		StringBuffer sb = new StringBuffer();
		while (i < 100) {
			sb.append(str);
			i++;
		}
	}
	
	public void add(String str1,String str2) {
		// sb只会在add方法中使用不会被别的线程使用（局部变量线程私有），
		// sb是不可能共享的资源，JVM会自动消除StringBuffer对象内部的锁
		StringBuffer sb = new StringBuffer();
		sb.append(str1).append(str2);
	}
}
