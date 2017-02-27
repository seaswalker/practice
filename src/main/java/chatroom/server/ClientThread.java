package chatroom.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.List;

/**
 * 处理客户端请求线程
 * @author skywalker
 *
 */
public class ClientThread implements Runnable {
	
	private Socket socket;
	private List<ClientThread> clients;
	private BufferedReader reader;
	private Writer writer;
	//客户端地址，示例:127.0.0.1:8080
	private String address;
	
	public ClientThread(Socket socket, List<ClientThread> clients) {
		this.socket = socket;
		this.clients = clients;
		init();
		sendClientList();
		clients.add(this);
	}
	
	//初始化
	private void init() {
		try {
			this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
			this.address = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//向客户端返回在线用户列表
	private void sendClientList() {
		StringBuilder list = new StringBuilder();
		if (clients.size() == 0) {
			list.append("没有在线用户\n");
		} else {
			list.append("用户列表:\n");
			for (ClientThread client : clients) {
				list.append(client.getAddress()).append("\n");
			}
		}
		try {
			writer.write(list.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//群发消息
	private void boardcast(String message) {
		try {
			message = address + ": " + message + "\n";
			for (ClientThread client : clients) {
				if (client != this) {
					client.writer.write(message);
					client.writer.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			clients.remove(this);
			reader.close();
			writer.close();
			socket.close();
			System.out.println(address + "下线");
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				String str = reader.readLine();
				if (str.equals("bye")) {
					close();
					break;
				} else {
					boardcast(str);
				}
			}
		} catch (IOException e) {
			close();
		}
	}

	public Reader getReader() {
		return reader;
	}
	public Writer getWriter() {
		return writer;
	}
	public String getAddress() {
		return address;
	}
	
}
