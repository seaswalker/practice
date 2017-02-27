package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组里面是否存在这样的情况:
 * nums[i] == nums[j], j - i <= k
 * 注意这种情况: 输入{1, 0, 1, 1}, 1
 * 其实是对的
 * @author skywalker
 *
 */
public class ContainsDuplicateII {

	//13ms
	private static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n;
		for (int i = 0, l = nums.length;i < l; ++i) {
			n = nums[i];
			if (map.containsKey(n)) {
				if (i - map.get(n) <= k) {
					return true;
				} else {
					map.put(n, i);
				}
			} else {
				map.put(n, i);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
	}
	
}
