package leetcode;

/**
 * 找出一个被旋转的数组中最小的元素
 * @author skywalker
 *
 */
public class FindMinimuminRotatedSortedArray {

	/**
	 * 最简单粗暴
	 * O(n) / 1ms
	 */
	@SuppressWarnings("unused")
	private static int findMin(int[] nums) {
		int min = nums[0];
		for (int i = 1, l = nums.length; i < l; ++i) {
			if (nums[i] < min) {
				min = nums[i];
			}
		}
		return min;
	}
	
	/**
	 * 1ms
	 * 其实是可以使用二分查找的 O(logn)
	 */
	private static int improve(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (mid == 0) {
				if (nums.length == 1 || nums[0] < nums[1]) {
					return nums[0];
				} else {
					++low;
				}
			} else if (nums[mid] < nums[mid - 1]) {
				return nums[mid];
			} else if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(improve(new int[] {4, 5, 6, 7, 1, 2, 3}));
		System.out.println(improve(new int[] {1, 2, 3, 4, 5}));
		System.out.println(improve(new int[] {2, 3, 4, 5, 1}));
		System.out.println(improve(new int[] {2, 1}));
		System.out.println(improve(new int[] {1, 2}));
		System.out.println(improve(new int[] {1}));
	}

}
