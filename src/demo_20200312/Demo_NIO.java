package demo_20200312;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * New IO/NIO
 * @author P1306792
 *
 */
public class Demo_NIO {
	public static void main(String[] args) throws IOException {
		testEZNIOUsage();
	}
	/**
	 * NIO的简单读写例子
	 * @throws IOException
	 */
	public static void testEZNIOUsage() throws IOException {
		String filePathForRead = "D:\\For Testing\\inter.txt";
		String filePathForWrite = "D:\\For Testing\\inter2.docx";
		// This reading type is not for reading from a large file.
		byte[] data = Files.readAllBytes(Paths.get(filePathForRead)); // read 
		Files.write(Paths.get(filePathForWrite), data, StandardOpenOption.CREATE_NEW); //write
		
	}

}
