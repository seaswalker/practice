package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 除了一个数字之外其它的都出现了3此，找出此数字
 * 要求:
 * 1. 时间复杂度O(n)
 * 2. 不使用辅助空间(想不出来...)
 * @author skywalker
 *
 */
public class SingleNumberII {

	//18ms
	private static int singleNumber(int[] nums) {
		//每个数字出现的次数
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n;
		for (int i = 0, l = nums.length;i < l; ++i) {
			n = nums[i];
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}
		for (int key : map.keySet()) {
			if (map.get(key) < 3) {
				return key;
			}
		}
		return -1;
	}
	
	/**
	 * 跪了...
	 * @see https://leetcode.com/discuss/6632/challenge-me-thx
	 */
	/*public int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}*/
	
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] {1, 2, 2, 1, 3, 2, 1}));
	}
	
}
