package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner in = null;
		try {
			//IP地址并不是固定的，使用ipconfig命令查看
			socket = new Socket("192.168.0.100", 8088);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			in = new Scanner(System.in);
			String str = null;
			while(true) {
				str = in.nextLine();
				//先发送可以解决服务器报错的问题
				dos.writeUTF(str);
				if(str.equals("bye")) {
					break;
				}
				System.out.println(dis.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
