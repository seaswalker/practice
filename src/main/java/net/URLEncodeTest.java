package net;

import java.io.UnsupportedEncodingException;

/**
 * URL编码测试
 * @author skywalker
 *
 */
public class URLEncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "http://www.baidu.com/";
		//String queryStr = "?key=3&id=ha";
		QueryString queryString = new QueryString("key", " 3");
		queryString.add("id", "ha");
		System.out.println(str + "?" + queryString.toString());
	}
	
}
