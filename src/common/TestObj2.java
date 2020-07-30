package common;

public class TestObj2 extends TestObj{

	public TestObj2(String val) {
		super(val);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj instanceof TestObj) {
			TestObj objet = (TestObj)obj;
			return this.value.equals(objet.value);
		}
		return false;
	}
}
