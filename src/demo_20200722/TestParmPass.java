package demo_20200722;

public class TestParmPass {

	public static void main(String[] args) {
		Integer integer = new Integer(1);
		changeVal(integer);
		System.out.println(integer);
		
	}
	
	public static void changeVal(Integer a) {
		a++;
	}

}
