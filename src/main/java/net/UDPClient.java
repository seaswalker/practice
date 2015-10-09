package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) {
		DatagramSocket dc = null;
		DatagramPacket dp = null;
		//接收
		DatagramPacket received = null;
		try {
			dc = new DatagramSocket();
			byte[] content = "hello server".getBytes();
			//服务器地址
			InetAddress inetAddress = InetAddress.getLocalHost();
			dp = new DatagramPacket(content, content.length, inetAddress, 8080);
			dc.send(dp);
			
			//接收服务器反馈
			byte[] receivedData = new byte[1024];
			received = new DatagramPacket(receivedData, receivedData.length);
			dc.receive(received);
			System.out.println("服务器反馈：" + new String(receivedData));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			dc.close();
		}
	}
	
}
