package leetcode;

import java.util.LinkedList;

/**
 * 判断给定的字符串是否是回文
 * Note:
 * 1.只需要考虑数字的字母(忽略大小写)
 * 2. ""被看做是有效的回文 
 * @author skywalker
 *
 */
public class ValidPalindrome {

	//14ms
	private static boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.equals("")) {
			return true;
		}
		char[] arr = new char[s.length()];
		int index = 0;
		char c;
		for (int i = 0, l = s.length();i < l; ++i) {
			c = s.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				arr[index++] = Character.toLowerCase(c);
			}
		}
		LinkedList<Character> stack = new LinkedList<Character>();
		int mid = index / 2;
		int b = index % 2 == 0 ? mid : mid + 1;
		for (int i = 0;i < mid; ++i) {
			stack.push(arr[i]);
		}
		for (;b < index; ++b) {
			if (!stack.isEmpty() && stack.peek() == arr[b]) {
				stack.pop();
			} else {
				break;
			}
		}
		return stack.isEmpty();
	}
	
	/**
	 * 上面的解法还是略显笨拙，下面的思路是unlock出来的:
	 * 只需要设置两个指针分别指向开始和末尾...
	 * 11ms
	 */
	private static boolean improve(String s) {
		if (s == null) {
			return false;
		}
		if (s.equals("")) {
			return true;
		}
		int low = 0, high = s.length() - 1;
		char lc, hc;
		while (low < high) {
			lc = Character.toLowerCase(s.charAt(low));
			hc = Character.toLowerCase(s.charAt(high));
			if (Character.isLetterOrDigit(lc) && Character.isLetterOrDigit(hc)) {
				if (lc != hc) {
					return false;
				} else {
					++low;
					--high;
					continue;
				}
			} else {
				if (!Character.isLetterOrDigit(lc)) {
					++low;
				}
				if (!Character.isLetterOrDigit(hc)) {
					--high;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(",'6``c4i,::,i4ckk6',"));
		System.out.println(improve(",'6``c4i,::,i4ckk6',"));
	}
	
}
