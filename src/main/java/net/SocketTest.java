package net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("www.baidu.com", 80);
		System.out.println("端口有服务");
		socket.close();
	}
	
}
