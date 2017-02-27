package encode;

import java.io.UnsupportedEncodingException;

/**
 * 娴嬭瘯缂栫爜
 * @author skywalker
 *
 */
public class Test1 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/*String str = "锻靛懙鍝?;
		byte[] b = str.getBytes("UTF-8");
		System.out.println(new String(b, "UTF-8"));
		
		Charset charset = Charset.forName("UTF-8");
		ByteBuffer bb = charset.encode("锻靛懙鍝?);
		CharBuffer cb = charset.decode(bb);
		System.out.println(cb.toString());*/
		
		//char[] array = "锻靛懙鍝?.toCharArray();
		//System.out.println(toHex('I'));
		
		System.out.println(toHex("I am 鍝埚搱"));
	}
	
	/**
	 * String杞?6杩涘埗
	 */
	public static String toHex(String str) {
		char[] array = str.toCharArray();
		//16杩涘埗鏁扮粍
		char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		byte[] bytes = new byte[2];
		StringBuffer sb = new StringBuffer();
		for(char c : array) {
			bytes[1] = (byte) (c & 0x00ff);
			bytes[0] = (byte) ((c & 0xff00) >> 8);
			for(byte b : bytes) {
				sb.append(chars[(b & 0xf0) >> 4]); 
				sb.append(chars[b & 0x0f]);
			}
			sb.append(" ");
		}
		return sb.toString();
	}
	
}
