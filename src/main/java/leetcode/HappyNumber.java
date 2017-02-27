package leetcode;

import java.util.HashSet;

/**
 * 判断给定的数字是否是happy number
 * @author skywalker
 *
 */
public class HappyNumber {

	/**
	 * 此题的难点在于如何判断不是--程序陷入死循环，但这个循环里没有1(废话)，这就是false
	 * 5ms
	 */
	private static boolean isHappy(int n) {
		if (n < 1) {
			return false;
		}
		if (n == 1) {
			return true;
		} 
		int sum = 0, i;
		//记录出现过的平方和，检测死循环
		HashSet<Integer> set = new HashSet<Integer>();
		while (true) {
			while (n > 0) {
				i = n % 10;
				sum += i * i;
				n /= 10;
			}
			if (sum == 1) {
				return true;
			}
			if (!set.add(sum)) {
				return false;
			}
			n = sum;
			sum = 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(15));
	}
	
}
