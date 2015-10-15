package datastructure;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by skywalker on 2015/10/15.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, -1, 0, 2, 5, 10, 4};
        sort(arr);;
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        if (arr != null) {
            int temp;
            //N - 1趟排序
            for (int i = 0, times = arr.length - 1;i < times;i ++) {
                for (int j = 0;j < times;j ++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

}
