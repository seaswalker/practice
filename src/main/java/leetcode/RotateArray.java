package leetcode;

import java.util.Arrays;

/**
 * 旋转数组，举个栗子:
 * with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * @author skywalker
 *
 */
public class RotateArray {

	/**
	 * System.arraycopy系native方法，底层使用汇编指令一次处理多条数据，比for循环更快，ArrayList中多次使用此方法
	 * @see http://www.360doc.com/content/14/0713/19/1073512_394157835.shtml
	 * 1ms
	 */
	private static void rotate(int[] nums, int k) {
		int l;
		if (nums == null || k < 1 || k == (l = nums.length)) {
			return;
		}
		if (k > l) {
			k %= l;
		}
		int[] temp = new int[l];
		System.arraycopy(nums, l - k, temp, 0, k);
		System.arraycopy(nums, 0, temp, k, l - k);
		System.arraycopy(temp, 0, nums, 0, l);
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2};
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
	
}
