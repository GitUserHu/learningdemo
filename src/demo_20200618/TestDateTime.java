package demo_20200618;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestDateTime {

	public static void main(String[] args) {
		System.out.println(Instant.now());
		// ， 获取今年的天数
		System.out.println("今年有" + LocalDate.now().lengthOfYear() + "天");
		System.out.println(LocalDate.of(1995, 1, 1).lengthOfYear());
		Map<String, String> hasMap = new HashMap<>();
		hasMap.isEmpty();
		List<String> list = new ArrayList<>(2);
		list.add("1");
		list.add("2");
		
		
		String[] tempArray = new String[] {"a", "b", "c", "d"};
		String[] array = list.toArray(tempArray);
		for (String str : array) {
			System.out.print(str+"\t");
		}
	
		String[] strArray = new String[] {"A", "B", "C", "D"};
		List<String> list2 = Arrays.asList(strArray);
		
		list.forEach((e)->{
			System.out.print(e+"\t");
		});
		strArray[0] = "changed";
		list.forEach((e)->{
			System.out.print(e+"\t");
		});
		
		// 
		Map<String, String> map = new HashMap<>(16);
		map.put("1", "A");
		map.put("2", "B");
		map.put("3", "C");
		map.put("4", "D");
		System.out.println();
		//， 会遍历2次。 第一次是转为key的Iterator对象，第二次是从map中取出key对应的值
		Iterator<String> keyIterator = map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			String value = map.get(key);
			System.out.println("["+ key+", "+value+"]");
		}
		//， 遍历一次就把key和value放到的entry中，效率更高。 推荐使用这种方式
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry entry : entrySet) {
			System.out.println("["+ entry.getKey()+", "+entry.getValue()+"]");
		}
		
		
		// JDK8 使用map.forEach遍历集合
		map.forEach((k, v)->{
			System.out.println("["+ k+", "+v+"]");
		});
		
	
	}

}
