package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 检测一个数组中是否有重复数据
 * Created by skywalker on 2015/10/19.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2};
        System.out.println(containsDuplicate(arr));
    }

    private static boolean containsDuplicate(int[] nums) {
        if (nums != null) {
            int length = nums.length;
            if (length > 1) {
                Set<Integer> set = new HashSet<>();
                int n;
                for (int i = 0;i < length;++i) {
                    n = nums[i];
                    //这样应该比先判断存在效率高
                    //先判断的话是16ms，这样是9ms
                    if (!set.add(n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
