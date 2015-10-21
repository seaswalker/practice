package leetcode;

import java.util.Arrays;

/**
 * 寻找缺失的数字
 * 测试:
 * {0, 1, 3} -> 2
 * {1} -> 0
 * {0} -> 1
 * {1, 0} -> 2
 * Created by skywalker on 2015/10/21.
 */
public class MissNumber {

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        System.out.println(better(nums));
    }

    /**
     * 15ms
     */
    private static int missingNumber(int[] nums) {
        if (nums != null) {
            int i = 0;
            Arrays.sort(nums);
            for (int l = nums.length;i < l;++i) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return i;
        }
        return 0;
    }

    /**
     * 更好，也许是最好的算法，还是XOR，原理就是a^b^b = a,所以最后剩下的一定是缺失的
     * 此解法和SingleNumber相似，然而还是没有想到
     * 仅需1ms
     */
    private static int better(int[] nums) {
        int xor = 0, i, l;
        for (i = 0, l = nums.length;i < l;++i) {
            xor ^= i ^ nums[i];
        }
        /**
         * 最后再次异或i的原因，如果没有缺失，那么应该返回下一个，而i正是下一个
         * 如果有缺失，那么最后一个元素应该比不缺失大1，而1正好可以抵消最后一个，太巧妙了
         */
        return xor ^ i;
    }

}
