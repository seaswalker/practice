package datastructure;

import java.util.Arrays;

/**
 * 插入排序
 * Created by skywalker on 2015/10/15.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, -1, 0, -8, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 执行插入排序
     * @param arr 数组
     */
    private static void sort(int[] arr) {
        if (arr != null) {
            int temp, position;
            for (int i = 1, l = arr.length;i < l;i ++) {
                position = i;
                for (int j = i - 1;j >= 0;j --) {
                    if (arr[j] > arr[position]) {
                        //交换
                        temp = arr[j];
                        arr[j] = arr[position];
                        arr[position] = temp;
                        -- position;
                    } else {
                        break;
                    }
                }
            }
        }
    }

}
