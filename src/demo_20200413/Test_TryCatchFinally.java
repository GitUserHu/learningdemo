package demo_20200413;

public class Test_TryCatchFinally {

	public static void main(String[] args) {
		
		System.out.println(getInt());
		
	}
	
	static int getInt() {
		int n = 10;
		try {
			n = n / 0;
		} catch (Exception e) {
			n = 20;
			return n;
		} finally {
			n = 30;
		}
		return n;
	} 

}
