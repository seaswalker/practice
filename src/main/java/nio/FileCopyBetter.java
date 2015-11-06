package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 实现文件复制--更好的方式
 * @author skywalker
 *
 */
public class FileCopyBetter {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("D:/java/eclipse/Practice/src/main/java/nio/test.txt").getChannel();
		FileChannel out = new FileOutputStream("C:/Users/skywalker/Desktop/test.txt").getChannel();
		in.transferTo(0, in.size(), out);
		//和上面是等价的
		//out.transferFrom(in, 0, in.size());
		System.out.println("copy sucess");
	}
	
}
