package leetcode;

/**
 * 做贼了...
 * @author skywalker
 *
 */
public class HouseRobber {
	
	/**
	 * 从别人那里看到的
	 * @see http://www.cnblogs.com/ganganloveu/p/4417485.html
	 * 这其实是一个动态规划的问题，关于动态规划，这有一个简洁的解释:
	 * @see http://www.bubuko.com/infodetail-1015504.html
	 * 0ms
	 */
	private static int solution(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int l = nums.length;
		int[] max = new int[l];
		max[0] = nums[0];
		max[1] = Math.max(nums[0], nums[1]);
		for (int i = 2;i < l;++i) {
			max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
		}
		return max[l - 1];
	}

	/**
	 * 测试数据:
	 * {1, 4, 3, 5, 2} -> 9
	 * {2, 1, 1, 2} -> 4
	 * {2, 2, 3, 1, 2, 5} -> 10
	 * 奇数个问题:
	 * {4, 1, 5, 3, 2} -> 11
	 * {2, 3, 2} -> 4
	 * {1, 2, 3, 1} - > 4 
	 * 此算法死在了这个栗子上: {1, 3, 1, 3, 100} -> 103
	 * 完全可以不从第二组(1, 3)中选一个，是在想不出咋办了...
	 */
	@SuppressWarnings("unused")
	private static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int moreMoney = 0, lessMoney = 0, l = nums.length;
		//两个一组进行遍历，pre是指上一组选择的是第一个还是第二个
		int pre = 1;
		for (int i = 1;i < l;i += 2) {
			if (nums[i] > nums[i - 1]) {
				moreMoney += nums[i];
				lessMoney += nums[i - 1];
				pre = 2;
			} else if (pre == 1) {
				moreMoney += nums[i - 1];
				lessMoney += nums[i];
			} else {
				moreMoney += nums[i];
				lessMoney += nums[i - 1];
				pre = 2;
			}
		}
		//如果有奇数个，并且之前是第1家时，应该加上最后一个
		if (l % 2 == 1) {
			if (pre == 1) {
				moreMoney += nums[l - 1];
			} else {
				lessMoney += nums[l - 1];
			}
		}
		return Math.max(moreMoney, lessMoney);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 3, 2}));
	}
	
}
