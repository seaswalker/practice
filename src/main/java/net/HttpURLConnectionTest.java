package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionTest {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://www.baidu.com");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		
		//输出服务器相应头部
		System.out.println("HTTP/1.1 " + http.getResponseCode() + " " + http.getResponseMessage());
		String key = null;
		String value = null;
		for(int i = 1; ;i ++) {
			key = http.getHeaderFieldKey(i);
			if(key == null) {
				break;
			}
			value = http.getHeaderField(key);
			System.out.println(key + ":" + value);
		}
		
		//输出响应的主体内容
		System.out.println();
		InputStream is = http.getInputStream();
		int temp = 0;
		while((temp = is.read()) != -1) {
			System.out.print((char) temp);
		}
	}
	
}
