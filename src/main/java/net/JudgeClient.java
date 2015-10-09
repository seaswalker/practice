package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 判断质数客户端
 * @author skywalker
 *
 */
public class JudgeClient {

	public static void main(String[] args) {
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner in = null;
		
		try {
			socket = new Socket("localhost", 8080);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			in = new Scanner(System.in);
			int input = 0;
			//输入
			while(true) {
				input = in.nextInt();
				if(0 < input && input < 2) {
					System.out.println("数字非法，请重新输入");
				}else if(input < 0) {
					System.exit(0);
				}else {
					break;
				}
			}
			dos.write(input);
			
			//处理返回数据
			int back = dis.read();
			if(back == 0) {
				System.out.println("不是质数");
			}else if(back == 1) {
				System.out.println("是质数");
			}else {
				System.out.println("出错");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			in.close();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
