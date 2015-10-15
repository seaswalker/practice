package datastructure;

import java.util.Arrays;

/**
 * 快排
 * Created by skywalker on 2015/10/15.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 4, 20, 30, 15, 1, 9, 100, 7};
        doQuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void doQuickSort(int[] arr, int low, int high) {
        if (arr != null && low < high) {
            int pos = quickSort(arr, low, high);
            doQuickSort(arr, low, pos - 1);
            doQuickSort(arr, pos + 1, high);
        }
    }

    /**
     * 执行一趟快速排序
     * @param arr 数组
     * @param low
     * @param high
     * @return 新的枢轴位置
     */
    private static int quickSort(int[] arr, int low, int high) {
        //枢轴
        int pivotkey = arr[low];
        //注意此层循环
        while (low < high) {
            while (high > low && arr[high] >= pivotkey) {
                -- high;
            }
            //下标为high和low互换
            swap(arr, low, high);
            while (low < high && arr[low] <= pivotkey) {
                ++ low;
            }
            swap(arr, high, low);
        }
        return low;
    }

    /**
     * 交换数组的两个下标值的元素
     * @param arr
     * @param f
     * @param s
     */
    private static void swap(int[] arr, int f, int s) {
        int temp;
        temp = arr[s];
        arr[s] = arr[f];
        arr[f] = temp;
    }

}
