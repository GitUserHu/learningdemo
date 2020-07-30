package demo_20200312;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 关于BIO BlockingIO
 * 基于流模型实现的，交互的方式同步，阻塞方式，也就是说在读入流或者输出流时，在读写动作完成之前，线程会一直阻塞，它们之间的调用是可靠的线性顺序。
 * 
 * 
 * InputStream、OutputStream 基于字节操作的 IO
 * Writer、Reader 基于字符操作的 IO
 * File 基于磁盘操作的 IO
 * Socket 基于网络操作的 IO
 * 
 * @author P1306792
 *
 */
public class Demo_BIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		testNormalIOUsingBuffer();
		//testReaderWriter();
	}
	/**
	 * 针对Writer Reader做读写测试
	 * @throws IOException
	 */
	public static void testReaderWriter() throws IOException {
		String filePathForRead = "D:\\For Testing\\test.txt";
		File fileForRead = new File(filePathForRead);
		if (!fileForRead.exists()) {
			System.out.println("File for reading not exists");
			return;
		}
		String filePathForWrite = filePathForRead.split("\\.")[0] + "2.txt";
		System.out.println("File name for write :" + filePathForWrite);
		File fileForWrite = new File(filePathForWrite);
		Reader reader = new FileReader(fileForRead);
		BufferedReader bufferedReader = new BufferedReader(reader);
		//char[] buffer = new char[2048];
		Writer writer = new FileWriter(fileForWrite, true);
		String lineStr = null;
		//StringBuffer sb = new StringBuffer();
		while ((lineStr = bufferedReader.readLine())!= null) {
			writer.write(lineStr);
			//sb.append(lineStr+"\n");
		}
		//sb.delete(sb.length()-2, sb.length()-1);
		
		bufferedReader.close();
		//writer.write(sb.toString());
		writer.close();
		reader.close();
		
		
		
		
	}
	
	/**
	 * 针对普通的InputStream OutputStream，做读写文件的测试。
	 * @throws IOException
	 */
	public static void testNormalInputOutputStream() throws IOException {
		String filePathForRead = "D:\\For Testing\\inter.txt";
		File fileForRead = new File(filePathForRead);
		if (!fileForRead.exists()) {
			System.out.println("File for reading not exists");
			return;
		}
		InputStream inputStream = new FileInputStream(fileForRead);
		byte[] data = new byte[inputStream.available()];
		System.out.println("Start to read...");
		inputStream.read(data);
		System.out.println("Finished to read...");
		
		String filePathForWrite = filePathForRead.split("\\.")[0] + ".docx";
		System.out.println("File name for write :" + filePathForWrite);
		File fileForWrite = new File(filePathForWrite);
		OutputStream outputStream = new FileOutputStream(fileForWrite);
		System.out.println("Start to write ...");
		outputStream.write(data);
		// outputStream.flush(); // FileOutputStream.flush() does nothing. this method extends from OutputSteam.flush(). it does nothing.
		System.out.println("Finish to write ...");
		
		System.out.println("Closing to I/O Stream ...");
		inputStream.close();
		outputStream.close();
	}
	
	public static void testNormalIOUsingBuffer() throws IOException {
		String filePathForRead = "D:\\For Testing\\test.txt";
		File fileForRead = new File(filePathForRead);
		if (!fileForRead.exists()) {
			System.out.println("File for reading not exists");
			return;
		}
		InputStream inputStream = new FileInputStream(fileForRead);
		//BufferedInputStream bis = new BufferedInputStream(inputStream);
		String filePathForWrite = "D:\\For Testing\\test_write.txt";
		File fileForWrite = new File(filePathForWrite);
		OutputStream outputStream = new FileOutputStream(fileForWrite);
		int bufferSize = 4;
		System.out.println("BufferSize : " + bufferSize);
 		byte[] buffer = new byte[bufferSize];
 		int count = 0;
 		System.out.println("AvailableSize : " + inputStream.available());
		while ((count = inputStream.read(buffer)) != -1) {
			//System.out.println(Arrays.toString(buffer));
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		//bis.close();
		inputStream.close();
		System.out.println("End");
	}

}
