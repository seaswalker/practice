package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) {
		DatagramSocket server = null;
		try {
			server = new DatagramSocket(8080);
			System.out.println("服务器已启动...");
			//接收客户端发送的数据
			byte[] recevied = new byte[1024];
			DatagramPacket dpRe = new DatagramPacket(recevied, recevied.length);
			server.receive(dpRe);
			System.out.println("收到客户端发来的数据：" + new String(recevied));
			
			
			//返回数据
			byte[] sended = "反馈来了".getBytes();
			//客户端的IP
			InetAddress inetAddress = dpRe.getAddress();
			//客户端端口号
			int port = dpRe.getPort();
			DatagramPacket content = new DatagramPacket(sended, sended.length, inetAddress, port);
			server.send(content);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			server.close();
		}
	}
	
}
