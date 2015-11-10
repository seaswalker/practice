package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器类
 * @author skywalker
 *
 */
public class Server {

	private static final int port = 8080;
	private ExecutorService service = Executors.newFixedThreadPool(10);
	private boolean running = true;
	//在线用户列表
	private final List<ClientThread> clients = new ArrayList<ClientThread>();
	private ServerSocket serverSocket;
	
	/**
	 * 启动服务器
	 */
	public void start() {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("服务器启动成功");
			while (running) {
				Socket socket = serverSocket.accept();
				ClientThread thread = new ClientThread(socket, clients);
				System.out.println(thread.getAddress() + "上线");
				service.execute(thread);
			}
		} catch (IOException e) {
			System.out.println(port + "端口已被占用，服务器启动失败");
		}
	}
	
	/**
	 * 关闭服务器
	 */
	public void stop() {
		try {
			running = false;
			serverSocket.close();
			service.shutdown();
		} catch (IOException e) {
			System.out.println("服务器关闭失败");
		}
	}
	
	public static void main(String[] args) {
		new Server().start();
	}
	
}
