package leetcode;

/**
 * 栗子:
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * @author skywalker
 *
 */
public class CountandSay {

	/**
	 * 返回的是第n个，不是前n个
	 * 1ms
	 * @param n
	 */
	private static String countAndSay(int n) {
		if (n < 1) {
			return "";
		}
		String result = "1";
		for (int i = 1;i < n; ++i) {
			result = next(result);
		}
		return result;
	}
	
	/**
	 * 生成下一个
	 * @param seed 非空
	 */
	private static String next(String seed) {
		char[] arr = seed.toCharArray();
		int l = arr.length, index = 0;
		StringBuilder sb = new StringBuilder();
		char c;
		while (index < l) {
			c = arr[index];
			//向后搜索相同字符
			int i = 1;
			++index;
			while (index < l && arr[index] == c) {
				++index;
				++i;
			}
			sb.append(i).append(c);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay(3));
	}
	
}
