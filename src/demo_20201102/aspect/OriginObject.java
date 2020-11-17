package demo_20201102.aspect;


public class OriginObject implements Origin{
	public void test() {
		System.out.println("core bussiness logic");
	}
	
	public void test2(String param1,String param2) throws Exception {
		System.out.println("test2");
		throw new Exception("throw exception to test");
	}
	
	public String test3() {
		System.out.println("test3");
		return "1";
	}
	
	public void nonTest() {
		System.out.println("nonTest");
	}
}
