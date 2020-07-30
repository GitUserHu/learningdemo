package demo_20200616;

import java.math.BigDecimal;
import java.util.Objects;

public class Test_aliJavaDevelopManual {

	public static void main(String[] args) {
		String a = null;
		String b = "1";
		Objects.equals(a, b);
		Integer intA = 10;
		Integer intB = 20;
		Integer intC = 200;
		Integer intD = -200;
		boolean equal = (intA == intB);
		boolean equals = (intC.equals(intD));
		
		
		float aF = 1.0f - 0.9f; 
		float bF = 0.9f - 0.8f; 
		if (aF == bF) {
			System.out.println("af == bF" );
		} else {
			System.out.println("af != bF" );
		}
		Float aFloat = Float.valueOf(aF);
		Float bFloat = Float.valueOf(bF);
		if (Objects.equals(aFloat, bFloat)) {
			System.out.println("af == bF" );
		} else {
			System.out.println("af != bF" );
		}
		
		System.out.println(aF-bF);
		// ，指定一个误差范围，两个浮点数的差值在此范围之内，则认为是相等的
		float diff = 1e-6f;
		if (Math.abs(aF - bF) < diff) {
			System.out.println("af == bF" );
		} else {
			System.out.println("af != bF" );
		}
		//， 使用BigDecimal 来定义值，再进行浮点数的运算操作
		BigDecimal bigDecimalA = new BigDecimal("1.0");
		BigDecimal bigDecimalB = new BigDecimal("0.9");
		BigDecimal bigDecimalC = new BigDecimal("0.8");
		BigDecimal x = bigDecimalA.subtract(bigDecimalB);
		BigDecimal y = bigDecimalB.subtract(bigDecimalC);
		System.out.println(Objects.equals(x, y));
		
		String str = "a,b,c,,";
		String[] split = str.split(",");
		System.out.println(split.length);
	}
}
