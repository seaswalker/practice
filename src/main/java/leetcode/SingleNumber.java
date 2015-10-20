package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 难度: 中等
 * 要求:
 * 1. 时间复杂度O(n)
 * 2. 不使用"extra memory"
 * Created by skywalker on 2015/10/20.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 2};
        System.out.println(better(arr));
    }

    /**
     * 使用HashMap实现，时间复杂度是O(N)，但是使用了辅助空间
     * 这样可以Accepted， 23ms
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int n;
        for (int i = 0, l = nums.length;i < l;++i) {
            n = nums[i];
            if (map.containsKey(n)) {
                map.put(n, Boolean.FALSE);
            } else {
                map.put(n, Boolean.TRUE);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key)) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 不使用辅助空间，使用XOR(异或)，这个真没想到...NB
     * @param nums
     * @return
     */
    private static int better(int[] nums) {
        int result = nums[0];
        for (int i = 1, l = nums.length;i < l;++i) {
            result ^= nums[i];
        }
        return result;
    }

}
