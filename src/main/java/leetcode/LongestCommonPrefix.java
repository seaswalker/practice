package leetcode;

/**
 * 找出字符串数组中最长的公共前缀
 * @author skywalker
 *
 */
public class LongestCommonPrefix {

	//3ms
	private static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0], str;
		int len, j;
		for (int i = 1, l = strs.length;i < l; ++i) {
			str = strs[i];
			//只需比较较短的串的长度位
			len = prefix.length() > str.length() ? str.length() : prefix.length();
			for (j = 0;j < len; ++j) {
				if (prefix.charAt(j) != str.charAt(j)) {
					break;
				}
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"abcde", "abcd", "abc"}));
	}
	
}
