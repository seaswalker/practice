package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 栗子:
 * given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 每个区间是一个连续的递增数列
 * @author skywalker
 *
 */
public class SummaryRanges {

	/**
	 * 1ms
	 * @param nums 数组已排好序，且没有重复
	 */
	private static List<String> summaryRanges(int[] nums) {
		int length;
		if (nums == null || (length = nums.length) == 0) {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<String>();
		int begin = nums[0], current = 0, next = 1, ci, ni;
		while (current < length) {
			ci = nums[current];
			if (next == length) {
				result.add(ci == begin ? String.valueOf(begin) : begin + "->" + ci);
				break;
			} else {
				ni = nums[next];
				//此处不能写成ni - ci > 1，如果输入是-2147483648,-2147483647,2147483647
				//第三个数减第二个数会溢出，结果还是1(无语...)
				if (ni - 1 > ci) {
					//断档
					result.add(ci == begin ? String.valueOf(begin) : begin + "->" + ci);
					begin = ni;
				}
				current = next++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[] {-2147483648,-2147483647,2147483647}));
	}
	
}
