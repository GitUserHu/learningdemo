package demo_20200319;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test_Array_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = new int[10];
		String[] strArray = new String[10];
		List<String> strList = new ArrayList<>();
		// List<int> inList = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		// testIteratorRemove(list); 
		testForEachRemove(list);
		System.out.println(list);
	}
	/**
	 * 正常的删除元素的操作
	 * @param <E>
	 * @param list
	 */
	public static <E> void testIteratorRemove(List<E> list) {
		Iterator<E> iterator = list.iterator();
		while (iterator.hasNext()) {
			E next = iterator.next();
			if (next.equals("c")) {
				iterator.remove();
			}
			
		}
	}
	/**
	 *  Foreach这种方式删除元素会导致异常ConcurrentModificationException。应该使用迭代器的方式去删除元素
	 * @param <E>
	 * @param list
	 */
	public static <E> void testForEachRemove(List<E> list) {
		for (E e : list) {
			if (e.equals("c")) {
				list.remove(e);
			}
		}
	}

}
