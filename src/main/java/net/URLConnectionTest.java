package net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.cafeaulait.org/books/jnp3/postquery.phtml");
		URLConnection connection = url.openConnection();
		//必须在打开输出流之前
		connection.setDoOutput(true);
		
		DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
		//设置查询字符串
		QueryString queryString = new QueryString("name", "skywalker");
		queryString.add("email", "xsdwem7@hotmail.com");
		
		//写入到服务器
		dos.writeUTF(queryString.toString());
		dos.close();
		
		//接收返回数据
		System.out.println("返回的数据如下：");
		//应该在写数据之后，否则拿到的是提交之前的返回结果
		InputStream is = connection.getInputStream();
		int temp = 0;
		while((temp = is.read()) != -1) {
			System.out.print((char) temp);
		}
	}
	
}
