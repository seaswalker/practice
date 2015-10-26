package leetcode;

/**
 * 求给定数的阶乘的末尾有多少个0
 * 时间复杂度O(logn)
 * @author skywalker
 *
 */
public class FactorialTrailingZeroes {

	private static int trailingZeroes(int n) {
		return Math.min(n / 2, n / 5);
	}
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(15));
	}
	
}
