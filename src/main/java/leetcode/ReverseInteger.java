package leetcode;

/**
 * 反转正数，举个栗子:
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * @author skywalker
 *
 */
public class ReverseInteger {

	/**
	 * 此题难点在于判断反转之后的数字会不会溢出，如果溢出返回0
	 * 2ms
	 */
	private static int reverse(int x) {
		long result = 0L;
		while (x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
	}
	
	/**
	 * 其他人的解法，原理就是如果溢出，那么新的result和原来的是不一样的
	 * @see https://leetcode.com/discuss/18785/my-accepted-15-lines-of-code-for-java
	 */
	@SuppressWarnings("unused")
	private static int another(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {
				return 0;
			}
			result = newResult;
			x = x / 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}
	
}
