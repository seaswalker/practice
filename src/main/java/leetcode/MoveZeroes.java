package leetcode;

import java.util.Arrays;

/**
 * 移动0至数组的末尾，同时保持非零数字的顺序，不可以新建一个数组
 * Created by skywalker on 2015/10/18.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 12, 0, 0};
        //move(nums);
        better(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void move(int[] nums) {
        if (nums != null) {
            //已经移至末尾的0的个数，用于计算下一个零向后移动时的截止位置
            int zeroes = 0, temp, i = 0, l = nums.length - 1;
            boolean moved;
            while (i < l) {
                if (nums[i] == 0) {
                    moved = false;
                    for (int j = i, d = l - zeroes;j < d;++ j) {
                        temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        moved = true;
                    }
                    ++ zeroes;
                    if (!moved) {
                        ++ i;
                    }
                } else {
                    ++ i;
                }
            }
        }
    }

    /**
     * 这个才是更好(最好?)的解法---不需要交换元素，时间复杂度O(n)
     * @param nums
     * @return
     */
    private static void better(int[] nums) {
        if (nums != null) {
            //0的个数
            int zeros = 0, l = nums.length;
            for (int i = 0;i < l;++ i) {
                if (nums[i] == 0) {
                    ++ zeros;
                } else {
                    //巧妙的地方
                    nums[i - zeros] = nums[i];
                }
            }
            //在数组的末尾填充0
            for (int i = 0;i < zeros;++ i) {
                nums[l - 1 - i] = 0;
            }
        }
    }

}
