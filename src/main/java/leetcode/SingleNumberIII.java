package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出只出现了一次的两个数字, 示例
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5]
 * Created by skywalker on 2015/10/19.
 */
@SuppressWarnings("unused")
public class SingleNumberIII {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }

    /**
     * Accepted 16ms
     * 时间复杂度O(N)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    private static int[] singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int[] result = new int[2];
        int pointer = 0, n;
        for (int i = 0, l = nums.length;i < l;++i) {
            n = nums[i];
            if (map.containsKey(n)) {
                map.put(n, Boolean.FALSE);
            } else {
                map.put(n, Boolean.TRUE);
            }
        }
        //迭代map，获取结果
        for (int key : map.keySet()) {
            if (map.get(key)) {
                result[pointer++] = key;
            }
        }
        return result;
    }

    /**
     * 别人的一个版本，仅使用了数组可能更快些
     * @param nums
     * @return
     */
    private static int[] another(int[] nums) {
        int[] rs = new int[2];
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1;) {
            if (nums[i] != nums[i + 1]) {
                rs[count] = nums[i];
                count++;
                i = i + 1;
            } else {
                i = i + 2;
            }
        }
        if(count==1){
            rs[1] = nums[nums.length-1];
        }
        return rs;
    }

}
