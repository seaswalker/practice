package leetcode;

/**
 * 转换锯齿形文字，有字符串PAYPALISHIRING,以Z字形书写:
 * P   A   H   N 
 * A P L S I I G
 * Y   I   R
 * 输出:PAHNAPLSIIGYIR
 * @author skywalker
 *
 */
public class ZigZagConversion {

	//12ms
	private static String convert(String s, int numRows) {
		if (s == null || s.equals("") || numRows < 1) {
			return "";
		}
		if (numRows == 1) {
			return s;
		}
		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0;i < numRows; ++i) {
			rows[i] = new StringBuilder();
		}
		boolean up = true;
		int index = 0;
		for (int i = 0, l = s.length();i < l; ++i) {
			rows[index].append(s.charAt(i));
			if (up) {
				++index;
				if (index == numRows - 1) {
					up = false;
				}
			} else {
				--index;
				if (index == 0) {
					up = true;
				}
			}
		}
		StringBuilder result = rows[0];
		for (int i = 1;i < numRows; ++i) {
			result.append(rows[i]);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convert("AB", 1));
	}
	
}
