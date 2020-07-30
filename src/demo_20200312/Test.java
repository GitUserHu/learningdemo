package demo_20200312;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		// String是final的，只是代表不能被继承，不代表不能被修改（重新赋值）
		// String的成员变量final char[] value一旦被定义就不能被修改。
		String string = "abc";
		string = "abd";
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			string  = string + i;
		}
	
		final String a = "123";
		String aa = "123";
		String b = "345" + a;
		String c = "345" + aa; // c跟new String("345123") chuangjian fangshi yizhi
		String d = "345123";
		System.out.println(b==c);
		System.out.println(b == d);
		//Integer
		char ch = 'a';
		System.out.println();
		int inta = 1 + 2;
		String chineseStr = "中";
		String englishStr = "A";
		int chineseStrLen = chineseStr.getBytes("UFT-8").length;
		int englishStrLen = englishStr.getBytes(Charset.forName("utf-16")).length;
		System.out.println(chineseStr + "length:" + chineseStrLen);
		System.out.println(englishStr + "length:" + englishStrLen);
		
	}
	
	
}
