package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 测试Channel用法
 * @author skywalker
 *
 */
public class Channel {

	/**
	 * 读取test.txt的内容 
	 */
	public static void main(String[] args) {
		FileChannel channel = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("D:/java/eclipse/Practice/src/main/java/nio/test.txt");
			channel = fileInputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(32);
			int bytesRead = channel.read(buffer);
			while (bytesRead != -1) {
				//准备读取
				buffer.flip();
				System.out.println("读取" + bytesRead + "字节");
				while (buffer.hasRemaining()) {
					System.out.print((char) buffer.get());
				}
				//重新读取
				buffer.clear();
				bytesRead = channel.read(buffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
