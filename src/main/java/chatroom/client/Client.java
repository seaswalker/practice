package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端类
 * @author skywalker
 *
 */
public class Client {
	
	private BufferedReader reader;
	private Writer writer;
	private Socket socket;
	private MessageThread thread;

	private void init() {
		try {
			socket = new Socket("localhost", 8080);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
			thread = new MessageThread(reader, this);
			System.out.println("连接到服务器");
			new Thread(thread).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		init();
		Scanner scanner = new Scanner(System.in);
		try {
			String str;
			while (true) {
				str = scanner.nextLine();
				writer.write(str + "\n");
				writer.flush();
				if ("bye".equals(str)) {
					stop();
					break;
				}
 			}
		} catch (IOException e) {
		}
	}
	
	public void stop() {
		try {
			reader.close();
			thread.stop();
			writer.close();
			socket.close();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client().run();
	}
	
}
