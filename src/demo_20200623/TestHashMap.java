package demo_20200623;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "4");
		map.put("E", "5");
		map.put("F", "6");
		map.put("G", "7");
		map.put("H", "8");
		System.out.println(("F".hashCode())>>>16);
		System.out.println(15&18);
		// （n=table的length）(n - 1) & hash 根据entry<k, v>的key的hash确定entry放入哪个桶，即HashMap中链式数组对应的下表
	}

}
