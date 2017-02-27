package net;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 测试URL类
 * @author skywalker
 *
 */
public class URLTest {

	public static void main(String[] args) {
		try {
			File file = new File("C:/Users/xsdwe_000/Desktop/Files/skywalker.txt");
			URL url = file.toURI().toURL();
			//System.out.println(url.toString());
			//file:/C:/Users/xsdwe_000/Desktop/Files/skywalker.txt
			
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			
			InputStreamReader isr = new InputStreamReader(is, "GBK");
			int temp = 0;
			while((temp = isr.read()) != -1) {
				System.out.print((char) temp) ;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
