package others;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 解码
 * @author skywalker
 *
 */
public class Decode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//笨笨
		System.out.println(URLDecoder.decode("%E7%AC%A8%E7%AC%A8", "UTF-8"));
	}
	
}
