package leetcode;

import java.util.Arrays;

/**
 * 合并两个排好序的数组
 * @author skywalker
 *
 */
public class MergeSortedArray {

	/**
	 * 假定nums1的空间是够用的
	 * 0ms
	 * @param nums1合并到此数组
	 * @param m nums1的初始长度
	 * @param nums2 
	 * @param n nums2的长度
	 */
	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int l = nums1.length;
		int[] result = new int[l];
		//nums1、nums2、result三个数组的索引
		int mi = 0, ni = 0, ri = 0;
		while (mi < m && ni < n) {
			if (nums1[mi] < nums2[ni]) {
				result[ri++] = nums1[mi++];
			} else {
				result[ri++] = nums2[ni++];
			}
		}
		while (mi < m) {
			result[ri++] = nums1[mi++];
		}
		while (ni < n) {
			result[ri++] = nums2[ni++];
		}
		System.arraycopy(result, 0, nums1, 0, l);
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 3, 5, 7, 0, 0, 0, 0};
		int[] nums2 = {2, 4, 6, 8};
		merge(nums1, 4, nums2, 4);
		System.out.println(Arrays.toString(nums1));
	}
	
}
