package demo_20200408;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import common.TestObj;
import common.TestObj2;

/**
 * HashMap的put()方法跟HashSet的add()方法表现的是相同的，因为HashSet的数据结构是HashMap，add()方法的内部是调用的hashMap的put()
   *   唯一不同的是，HashSet的只有Key，其底层的map的value是一个默认的Object的对象PRESENT(Object PRESENT = new Object())
   *   Map的key和value都可以允许null
 * @author P1306792
 *
 */
public class Test_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestObj obj1 = new TestObj("obj1");
		TestObj obj2 = new TestObj("obj2");
		TestObj objNull = new TestObj("null obj");
		Map<Object, String> map = new HashMap<>();
		map.put(obj1, "1");
		map.put(obj2, "2");
		map.put(null, null);
		map.put(null, "null");
		map.put(objNull, null);
		System.out.println("Map size is " + map.size());
		Iterator<Object> iterator = map.keySet().iterator();
		
		while (iterator.hasNext()) {
			Object obj = (Object) iterator.next();
			System.out.print(obj+ " : " + map.get(obj) + "\t");
			
		}
		TestObj obj3 = new TestObj2("obj3");
		TestObj obj4 = new TestObj2("obj4");
		Map<Object, String> map2 = new HashMap<>();
		map2.put(obj3, "3");
		map2.put(obj4, "4");
		System.out.println("\nMap2 size is " + map2.size());
		Iterator<Object> iterator2 = map2.keySet().iterator();
		
		while (iterator2.hasNext()) {
			Object obj = (Object) iterator2.next();
			System.out.print(obj.toString()+ " : " + map2.get(obj) + "\t");
			
		}
	}

}
