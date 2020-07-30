package demo_20200318;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.TestObj;

public class Demo_List_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestObj obj = new TestObj("abc");
		TestObj obj2 = new TestObj("def");
		//System.out.println(obj.value == obj2.value);
		Set<TestObj> hashSetObj = new HashSet<>(); 
		hashSetObj.add(obj);
		hashSetObj.add(obj2);
		for (TestObj tmp : hashSetObj) {
			System.out.println(tmp);
		}
		
		// Hashset how to compare? a.hashcode == b.hashcode && ((a == b) || a.equals(b))  
		// HashSet底层是HashMap，那么HashSet.add(E e)方法的操作流程是怎样的呢?
		// 1.找到对应的hash桶，如果没找到对应的hash桶，则直接创建一个桶存放元素e，如果找到了对应Hash桶，则比较这个桶中的节点p的值是否等于(p.key==e)e,或者e.equals(p.key)
		// 2. 如果不满足则在当前节点p.next = new Node<>(hash, e, value, null);
		// 3. 如果满足，不将该元素放入容器
		Set<String> hashSet = new HashSet<>(); 
		hashSet.add("a");
		hashSet.add("c");
		hashSet.add("b");
		hashSet.add("a");
		System.out.println("通话".hashCode() + " ? " + "重地".hashCode());
		hashSet.add("通话");
		hashSet.add("重地");
		System.out.println("Set:");
		for (String s : hashSet) {
			System.out.println(s);
		}
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("b");
		list.add("a");
		System.out.println("List:");
		for (String s : list) {
			System.out.println(s);
		}
	}
	
}
