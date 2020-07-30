package demo_20200708;

public class TestDataInSameCacheLine {
	static long count = 100000000L;
	static long temp = 1L;
	public static void main(String[] args) throws InterruptedException {
		TestObj[] array = new TestObj[2];
		array[0] = new TestObj();
		array[1] = new TestObj();
		Thread one = new Thread(()->{
			for (int i = 0; i < count; i++) {
				array[0].x = temp;
			}
		});
		Thread two = new Thread(()->{
			for (int i = 0; i < count; i++) {
				array[1].x = temp;
			}
		});
		long start = System.currentTimeMillis();
		one.start();
		two.start();
		one.join();
		two.join();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
class TestObj{
	volatile long x;
}
