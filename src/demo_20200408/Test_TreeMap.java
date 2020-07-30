package demo_20200408;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 	如果Key对应的类实现的比较器是顺序方式（即： a < b， a.compareTo(b) 返回 -1），TreeMap放入元素时，父节点 > 左子节点， 父节点 < 右子节点
   *     如果Key对象的类实现的比较器是倒序方式（即：a < b， a.compareTo(b) 返回 1）， TreeMap放入元素时，父节点 < 左子节点， 父节点 > 右子节点
 *  TreeMap的遍历方式是中序，即 左 ->  中 -> 右
  *       在构建TreeMap时如果没设定Key比较器，那么往TreeMap中放入元素时就会使用Key对应的类实现的比较器。
  *       如果既没有设定比较器，Key对应的类也未实现比较器，那么就会出现运行时异常，ClassCastException
  *      参考put()方法的这行代码：    Comparable<? super K> k = (Comparable<? super K>) key;
 *  TreeMap遍历的主要代码：  在遍历的最开始，第一个传入successor()方法的元素是整个树的最左边的叶子节点,如下图就是D
 *  			A
 *  	B				C
 *  D		E		F		G
 *  static <K,V> TreeMap.Entry<K,V> successor(Entry<K,V> t) {
        if (t == null)
            return null;
        else if (t.right != null) {
            Entry<K,V> p = t.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            Entry<K,V> p = t.parent;
            Entry<K,V> ch = t;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }  
    
    
 * @author P1306792
 *
 */
public class Test_TreeMap {

	public static void main(String[] args) {
		TreeMap<String, String> treeMap = new TreeMap<>() ;
		String str1 = "12";
		String str2 = "123";
		String str3 = "1234";
		//System.out.println(str1.compareTo(str2));
		treeMap.put(str1, "1");
		treeMap.put(str2, "2");
		treeMap.put(str3, "3");
		// TreeMap是用中序遍历
		System.out.println("升序");
		Iterator<Entry<String, String>> iterator = treeMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
			System.out.println("[" + entry.getKey() + " ," + entry.getValue() + "]");
		}
		
		TreeMap<String, String> treeMapWithIterator = new TreeMap<>((x, y)->{
			return y.compareTo(x);
		});
		treeMapWithIterator.put(str1, "1");
		treeMapWithIterator.put(str2, "2");
		treeMapWithIterator.put(str3, "3");
		System.out.println("降序：");
		// TreeMap是用中序遍历
		Iterator<Entry<String, String>> iterator2 = treeMapWithIterator.entrySet().iterator();
		while (iterator2.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator2.next();
			System.out.println("[" + entry.getKey() + " ," + entry.getValue() + "]");
		}
	}

}
