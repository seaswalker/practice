package datastructure;

/**
 * 二分查找
 * Created by skywalker on 2015/10/15.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 9, 11, 20};
        System.out.println(binarySearch(arr, 20, 0, arr.length - 1));
    }

    /**
     * 执行二分查找
     * @param arr 数组(有序)
     * @param number 需要查找的元素
     * @param begin 起始位置
     * @param end 结束位置
     * @return 目标元素的下标值
     */
    private static int binarySearch(int[] arr, int number, int begin, int end) {
        if (arr != null && begin < end) {
            int middle = (begin + end) >>> 1;
            if (arr[middle] == number) {
                return middle;
            } else if (number > arr[middle]) {
                return binarySearch(arr, number, middle + 1, end);
            } else {
                return binarySearch(arr, number, begin, middle - 1);
            }
        }
        return -1;
    }

}
