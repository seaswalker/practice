package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 支持多个客户端的服务器
 * @author skywalker
 *
 */
public class MultiServer {
	
	private static int counter = 1;

	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket socket = null;
		try {
			ss = new ServerSocket(8088);
			System.out.println("服务器已启动....");
			while(true) {
				socket = ss.accept();
				//交由一个线程处理
				new LogicThread(socket).start();
				System.out.println("已连接" + (counter ++) + "个客户端。");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

/**
 * 业务处理逻辑
 * @author skywalker
 *
 */
class LogicThread extends Thread {
	
	private Socket socket;
	
	public LogicThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		DataInputStream dis;
		try {
			dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while(true) {
				String input = dis.readUTF();
				if(input.equals("bye")) {
					break;
				}
				//返回客户端
				dos.writeUTF("返回自服务器：" + input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
