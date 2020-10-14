package demo_20200918;
/**
 * Synchronized 实现过程
 * 1. java代码层： synchronized关键字
 * 2. java字节码层： 加入monitorenter/monitorexit
 * 3. x 执行过程中，JVM自动升级
 * 4. x 底层 lock comxchg
 * @author P1306792
 *
 */
public class SynchronizedImplement {
	public static void main(String[] args) {
		synchronized (String.class) {
			
		}
	}
}
