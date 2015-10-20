package leetcode;

import java.util.Arrays;

/**
 * 注意此题: 是看了别人的思路做出来的
 * 根据给定的数组建立一个新数组，新数组的每个元素是除自己之外的其它元素的乘积，示例:
 * For example, given [1,2,3,4], return [24,12,8,6]
 * 特别要求:
 * 1. 时间复杂度O(N)
 * 2. 不能用除法
 * 3. 空间复杂度O(1), 但是新数组不属于空间复杂度
 * 测试数据:
 * {1, 2, 3, 4} -> {24, 12, 8, 6}
 * {0, 0} -> {0, 0}
 * Created by skywalker on 2015/10/20.
 */
public class ProductArray {

    public static void main(String[] args) {
        int[] arr = {0, 0};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    /**
     * 思路就是设置两个辅助数组(result数组当作一个，这样空间复杂度就是O(1)了)，其中一个数组保存:
     * 从前开始(1)迭代，保存当前位置(i)之前所有数的乘积
     * 另一个数组保存从后面开始迭代的结果
     * 这样两个数组同样位置的元素相乘就是所求结果，非常巧妙
     * @param nums
     * @return
     */
    private static int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] result = new int[l];
        int[] left = new int[l];
        left[0] = 1;
        result[l - 1] = 1;
        //设置left数组，就是迭代原数组(从1开始)，每一个元素都是i之前元素的乘积
        for (int i = 1;i < l;++i) {
            left[i] = left[i - 1] * nums[i - 1];
            result[l - i - 1] = result[l - i] * nums[l - i];
        }
        //计算结果
        for (int i = 0;i < l;++i) {
            result[i] *= left[i];
        }
        return result;
    }

}
