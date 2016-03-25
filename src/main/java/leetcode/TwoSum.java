package leetcode;

import java.util.Arrays;

/**
 * example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @author skywalker
 *
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		if (nums == null) return null;
		for (int i = 0, l = nums.length;i < l; i++) {
			for (int j = i + 1;j < l; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] {2, 12, 11, 7},  9)));
	}
	
}
