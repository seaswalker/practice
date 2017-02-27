package leetcode;

import java.util.Arrays;

/**
 * 把一个已经排好序的数组中的重复值删掉
 * 此题和RemoveElement相似
 * @author skywalker
 *
 */
public class RemoveDuplicates {

	private static int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int n = 1;
		for (int i = 1, l = nums.length;i < l;++i) {
			if (nums[i] > nums[i - 1]) {
				nums[n++] = nums[i];
			}
		}
		return n;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
	
}
