package demo_20200708;
/**
 * 验证指令重排序的例子（乱序）
 * @author jiabing
 *
 */
public class TestVolatile {
	static int a, b, x,y;
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		
        while (true) {
        	 a = 0; b = 0;
             x = 0; y = 0;
        	i++;
        	Thread one = new Thread(()->{
        		a = 1;
        		x = b;
        	}); 
        	Thread two = new Thread(()->{
        		b = 1;
        		y = a;
        	}); 
        	one.start();
        	two.start();
        	one.join();
        	two.join();
        	if (x == 0 && y == 0) {
        		System.err.println("第"+i+"次"+": ("+x+", "+y+")");
        		break;
        	}
        }

	}

}
