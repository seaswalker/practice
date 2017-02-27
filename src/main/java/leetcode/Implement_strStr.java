package leetcode;

/**
 * 在给定的字符串中寻找另一个串第一次出现的位置
 * @author skywalker
 *
 */
public class Implement_strStr {

	/**
	 * 寻找/6ms
	 * 时间复杂度O(m x n)，改进算法可以使用KMP(O(m + n))
	 * @param haystack 被寻找的串
	 * @param needle 寻找的串
	 * @return index
	 */
	private static int strStr(String haystack, String needle) {
		if (isEmpty(needle) && isEmpty(haystack)) {
			return 0;
		}
		int hi = 0, ni = 0, hl = haystack.length(), nl = needle.length();
		while (hi < hl && ni < nl) {
			if (haystack.charAt(hi) == needle.charAt(ni)) {
				++hi;
				++ni;
			} else {
				hi = hi - ni + 1;
				ni = 0;
			}
		}
		return ni == nl ? hi - nl : -1;
	}
	
	private static boolean isEmpty(String str) {
		return str == null || str.equals("");
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("", "a"));
	}
	
}
