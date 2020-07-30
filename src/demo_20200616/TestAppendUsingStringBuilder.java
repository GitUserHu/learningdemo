package demo_20200616;

public class TestAppendUsingStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			stringBuilder.append(i);
		}
		result = stringBuilder.toString();
		System.out.println(result);
	}

}
