package leetcode;

import java.util.Arrays;

/**
 * 加一
 * @author skywalker
 *
 */
public class PlusOne {

	private static int[] plusOne(int[] digits) {
		if (digits == null) {
			return null;
		}
		//进位
		int bit = 1, sum, l = digits.length - 1;
		for (int i = l;i >= 0;--i) {
			sum = digits[i] + bit;
			if (sum == 10) {
				digits[i] = 0;
				bit = 1;
			} else {
				bit = 0;
				digits[i] = sum;
				break;
			}
		}
		if (bit == 1) {
			int[] result = new int[l + 2];
			result[0] = 1;
			for (int i = 0;i <= l;++i) {
				result[i + 1] = digits[i];
			}
			return result;
		} else {
			return digits;
		}
	}
	
	public static void main(String[] args) {
		int[] digits = {9, 9, 9};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
	
}
