package demo_20200413;

public class TesttryCatchFinally {

public static void main(String[] args) {
		System.out.println(getInt());
		
	}
	
	static int getInt() {
		int n = 10;
		try {
			n = n / 0;
		} catch (Exception e) {
			return print1();
		} finally {
			return print2();
		}
	} 
	
	static int print1() {
		System.out.println("print1 function");
		return 0;
		
	}
	
	static int print2() {
		System.out.println("print2 function");
		return 0;
		
	}

}
