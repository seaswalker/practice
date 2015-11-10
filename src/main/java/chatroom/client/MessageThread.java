package client;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 客户端后台接受消息
 * @author skywalker
 *
 */
public class MessageThread implements Runnable {

	private BufferedReader reader;
	//相关联的客户端
	private Client client;
	private boolean running = true;
	
	public MessageThread(BufferedReader reader, Client client) {
		this.reader = reader;
		this.client = client;
	}
	
	public void stop() {
		running = false;
	}

	@Override
	public void run() {
		try {
			while (running) {
				String str = reader.readLine();
				if (str != null)
					System.out.println(str);
			}
		} catch (IOException e) {
			client.stop();
		}
	}

}
