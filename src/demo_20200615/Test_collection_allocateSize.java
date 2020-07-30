package demo_20200615;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * 初始化集合时，一定要根据数据量的大小设置集合的容量，否则性能上会出问题。
 * 拿最简单的集合ArrayList作例子：
 * 添加10000000条数据，设置了集合容量的数组集合用时14秒，未设置容量的数组集合用时19s（未设置容量的集合在添加元素时会不断的扩容）
 * @author jiabing
 *
 */
public class Test_collection_allocateSize {
	static final int SIZE = 20000000;
	public static void main(String[] args) {
		
		System.out.println(15>>1);
		/*
		 * List<String> list = new ArrayList<>(); List<String> list2 = new
		 * ArrayList<>(SIZE); new Thread(()->{ notSpecifyingCollectionSize(list);
		 * }).start();
		 * 
		 * new Thread(()->{ specifyCollectionSize(list2); }).start();
		 */
		
	}
	
	public static void specifyCollectionSize(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			list.add(String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println(start + " to " + end);
		System.out.println(list.size());
		System.out.println("指定大小的集合添加"+ SIZE +"个元素用时： "+ (end-start) + " ms");
	}

	public static void notSpecifyingCollectionSize(List<String> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			list.add(String.valueOf(i));
		}
		
		long end = System.currentTimeMillis();
		System.out.println(start + " to " + end);
		System.out.println(list.size());
		System.out.println("不指定大小的集合添加"+ SIZE +"个元素用时： "+ (end-start) + " ms");
	}
}
