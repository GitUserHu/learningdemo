package common;
/**
 * TestObj 的所有实例对象的hashcode时一样的，已经equals()方法判定都是true
 * @author P1306792
 *
 */
public class TestObj {
	String value ;
	public TestObj(String val) {
		value = val;
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	@Override
	public int hashCode() {
		
		return 1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
}

