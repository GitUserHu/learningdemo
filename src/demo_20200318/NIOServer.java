package demo_20200318;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
	private int flag = 0;
	private static final int CAPACITY = 4096;
	private ByteBuffer sendBuffer = ByteBuffer.allocate(CAPACITY);
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(CAPACITY);
	private Selector selector;
	public NIOServer(int port) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		ServerSocket serverSocket = serverSocketChannel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("Server start ... on port(" + port+ ")");
	}
	
	public static void main(String[] args) throws IOException {
		int port = 8888;
		NIOServer nioServer = new NIOServer(port);
		nioServer.listen();
	}
	
	private void listen() throws IOException {
		while (true) {
			selector.select();
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			System.out.println("Server : selectedKeys size = " + selectedKeys.size());
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) iterator.next();
				iterator.remove();
				handleKey(selectionKey);
			}
			
		}
	}
	
	private void handleKey(SelectionKey selectionKey) throws IOException {
		ServerSocketChannel server = null;
        SocketChannel client = null;
        String receiveText;
        String sendText;
        int count = 0;
        
        if (selectionKey.isAcceptable()) {
           
            server = (ServerSocketChannel) selectionKey.channel();
            
            client = server.accept();
            
            client.configureBlocking(false);
            
            client.register(selector, SelectionKey.OP_READ);
        } else if (selectionKey.isReadable()) {
            
            client = (SocketChannel) selectionKey.channel();
           
            receiveBuffer.clear();
            count = client.read(receiveBuffer);
            if (count > 0) {
                receiveText = new String( receiveBuffer.array(), 0, count);
                System.out.println("server received msg from client: "+receiveText);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        } else if (selectionKey.isWritable()) {
        
        	sendBuffer.clear();
          
            client = (SocketChannel) selectionKey.channel();
            sendText="message from server--" + flag++;
   
            sendBuffer.put(sendText.getBytes());

            sendBuffer.flip();
     
            client.write(sendBuffer);
            System.out.println("Server sends msg to Client -- "+sendText);
            client.register(selector, SelectionKey.OP_READ);
        }

	}
}
