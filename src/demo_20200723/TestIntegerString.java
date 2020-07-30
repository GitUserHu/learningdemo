package demo_20200723;

public class TestIntegerString {

	public static void main(String[] args) {
		Integer val1 = new Integer(10);
		String val2 = new String ("abc");
		changeVal(val1);
		changeVal(val2);
		System.out.println(val1);
		System.out.println(val2);

	}
	public static void changeVal(String val) {
		val = new String("bcd");
	}
	
	public static void changeVal(Integer val) {
		val = new Integer(100);
	}
}
