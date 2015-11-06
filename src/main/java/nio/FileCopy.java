package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 实现文件复制
 * @author skywalker
 *
 */
public class FileCopy {
	
	private static int size = 1024;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("D:/java/eclipse/Practice/src/main/java/nio/test.txt").getChannel();
		FileChannel out = new FileOutputStream("C:/Users/skywalker/Desktop/test.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(size);
		while (in.read(buffer) != -1) {
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
		System.out.println("copy sucess");
	}
	
}
