package net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 查询字符串编码
 * @author skywalker
 *
 */
public class QueryString {

	private StringBuilder sb = new StringBuilder();
	
	public QueryString(String name, String value) {
		encode(name, value);
	}
	
	public void encode(String name, String value) {
		try {
			sb.append(URLEncoder.encode(name, "UTF-8"));
			sb.append("=");
			sb.append(URLEncoder.encode(value, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void add(String name, String value) {
		sb.append("&");
		encode(name, value);
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
	
}
