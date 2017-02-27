package leetcode;

/**
 * 和最大的子序列, 栗子:
 * given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 此题是Mark Allen Weiss的数据结构与算法分析一书的例子
 * @author skywalker
 *
 */
public class MaximumSubarray {
	
	/**
	 * 1ms
	 * 时间复杂度O(n)，参考:
	 * @see http://www.tuicool.com/articles/IbiMjaI(动态规划)
	 * @param nums 最少有一个元素
	 */
	private static int maxSubArray(int[] nums) {
		int sum, max;
		sum = max = nums[0];
		for (int i = 1, l = nums.length;i < l; ++i) {
			if (sum < 0) {
				sum = 0;
			}
			sum += nums[i];
			max = Math.max(sum, max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}

}
