package leetcode;

/**
 * 判断数字是否是回文数字
 * @author skywalker
 *
 */
public class PalindromeNumber {

	//11ms
	private static boolean isPalindrome(int x) {
		int num = 0, temp = x;
		while (temp > 0) {
			num = num * 10 + temp % 10;
			temp /= 10;
		}
		return num == x;
	} 
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(142));
	}
	
}
