package leetcode;

import java.util.Arrays;

/**
 * 题意是这样的:
 * 从数组中去除某个值，返回新数组的长度；注意在去除完毕后数组中的元素应该变化了，即出现value的位置都被替换掉了，
 * 最后一句的意思是 新长度后面的元素值任意，也就是说，新数组的总长度可以保持不变，但是新长度之前的元素要正确，后面的无所谓。
 * 一开始理解错了
 * @author skywalker
 *
 */
public class RemoveElement {

	private static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }   
        int n = 0;
        for (int i = 0, l = nums.length;i < l;++i) {
            if (nums[i] != val) {
            	nums[n++] = nums[i];
            }
        }
        return n;
    }
	
	public static void main(String[] args) {
		int[] nums = {4, 5};
		System.out.println(removeElement(nums, 4));
		System.out.println(Arrays.toString(nums));
	}
	
}
