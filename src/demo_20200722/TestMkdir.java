package demo_20200722;

import java.io.File;

public class TestMkdir {

	public static void main(String[] args) {
		String path = "D:/test/file/";
		new File(path).mkdir();
		new File(path).mkdirs();
	}

}
