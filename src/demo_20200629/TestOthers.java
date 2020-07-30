package demo_20200629;

import java.util.Optional;

public class TestOthers {

	public static void main(String[] args) {
		System.out.println(test());	
		String str = null;
		Optional<String> optional = Optional.of(str);
		
		// optional.orElseThrow(null);
		// System.out.println(optional.get());
	}
	
	public static int returnFunction(int n) {
		System.out.println("call return function " +  n);
		return n;
	}
	
	public static int test() {
		try {
			return returnFunction(1); // 这里的return 会被丢弃，整个方法的return来自finally代码块。
		} finally {
			return returnFunction(2);
		}
		
	}

}
