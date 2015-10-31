package leetcode;

/**
 * 给定一个排好序的数组，如果值已经存在，那么返回其位置，如果不存在，返回应该插入的位置，一堆栗子:
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * @author skywalker
 *
 */
public class SearchInsertPosition {

	/**
	 * 1ms
	 * @param nums 数组是没有重复的
	 */
	private static int searchInsert(int[] nums, int target) {
		int index = 0, l = nums.length;
		while (index < l && nums[index] < target) {
			++index;
		}
		return index;
	}
	
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0));
	}
	
}
