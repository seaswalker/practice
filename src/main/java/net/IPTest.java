package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
		System.out.println("百度地址为：" + inetAddress1.getHostAddress());
		
		inetAddress1 = InetAddress.getLocalHost();
		System.out.println("本地地址为：" + inetAddress1.getHostAddress());
		
		inetAddress1 = InetAddress.getByName("61.135.169.121");
		System.out.println("61.135.169.121:" + inetAddress1.getCanonicalHostName());
	}
	
}
