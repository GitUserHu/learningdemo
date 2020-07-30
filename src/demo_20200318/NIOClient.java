package demo_20200318;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	private static int flag = 0;
	private static final int CAPACITY = 4096;
	private static  ByteBuffer sendBuffer = ByteBuffer.allocate(CAPACITY);
	private static  ByteBuffer receiveBuffer = ByteBuffer.allocate(CAPACITY);
	private final static InetSocketAddress SERVER_ADDRESS = new InetSocketAddress("localhost", 8888);
	
	public static void main(String[] args) throws IOException {
		testClient();
	}
	
	public static void testClient() throws IOException {
		SocketChannel  socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		socketChannel.connect(SERVER_ADDRESS);
		Set<SelectionKey> selectionKeys;
		Iterator<SelectionKey> iterator;
		SelectionKey selectionKey;
		SocketChannel client;
		String receivedContent;
		String sentContent;
		int count = 0;
		while (true) {
			selector.select();
			selectionKeys = selector.selectedKeys();
			System.out.println("SelectionKeys size = " + selectionKeys.size());
			iterator = selectionKeys.iterator();
			while (iterator.hasNext()) {
				selectionKey  =  iterator.next();
				if (selectionKey.isConnectable()) {
					System.out.println("Client connecting ...");
					client = (SocketChannel) selectionKey.channel();
					if (client.isConnectionPending()) {
						client.finishConnect();
						System.out.println("Client connected ...");
						sendBuffer.clear();
						sendBuffer.put("Hello, Server.".getBytes());
						sendBuffer.flip();
						client.write(sendBuffer);
					}
					client.register(selector, SelectionKey.OP_READ);
				} else if (selectionKey.isReadable()) {
					client = (SocketChannel) selectionKey.channel();
					receiveBuffer.clear();
					count = client.read(receiveBuffer);
					if (count > 0) {
						receivedContent = new String(receiveBuffer.array(), 0, count);
						System.out.println("Content sent from Server : " + receivedContent);
						client.register(selector, SelectionKey.OP_WRITE);
					}
				} else if (selectionKey.isWritable()) {
					sendBuffer.clear();
					client = (SocketChannel) selectionKey.channel();
					sentContent = "msg sent from client -- " + (flag++);
					sendBuffer.put(sentContent.getBytes());
					sendBuffer.flip();
					client.write(sendBuffer);
					System.out.println("Client sent msg to server: "+ sentContent);
					client.register(selector, SelectionKey.OP_READ);
				}
				
			}
			selectionKeys.clear();
		}
		
	}
}
