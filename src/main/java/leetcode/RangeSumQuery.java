package leetcode;

import java.util.Arrays;

/**
 * 求出数组中任意一段的和
 * @author skywalker
 *
 */
public class RangeSumQuery {

	private int[] arr;
	
	public RangeSumQuery(int[] arr) {
		this.arr = Arrays.copyOf(arr, arr.length);
	}
	
	public int sumRange(int i, int j) {
        if (i < 0 || j < 0 || i > j) return 0;
        int sum = 0;
        for (;i <= j;i ++) {
        	sum += arr[i];
        }
        return sum;
    }
	
	public static void main(String[] args) {
		/*RangeSumQuery range = new RangeSumQuery(new int[] {-2, 0, 3, -5, 2, -1});
		System.out.println(range.sumRange(0, 2));
		System.out.println(range.sumRange(2, 5));
		System.out.println(range.sumRange(0, 5));*/
		int[] arr = new int[2];
		System.out.println(arr[1]);
	}
	
}
