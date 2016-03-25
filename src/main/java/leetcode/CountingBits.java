package leetcode;

import java.util.Arrays;

/**
 * 计算从[0, n]的所有数字的二进制形式中1的个数
 * @author amp
 *
 */
public class CountingBits {

	public static int[] countBits(int num) {
		if (num < 0) throw new IllegalArgumentException("the param num can't be negative.");
		int[] bits = new int[num + 1];
		for (int i = 0;i <= num; i++) {
			bits[i] = Integer.bitCount(i);
		}
		return bits;
	}
	
	/**
	 * 别人的算法: https://leetcode.com/discuss/93807/simple-java-dynamic-programming-without-bitwise-operation
	 */
	public static int[] better(int num) {
		int[] bits = new int[num + 1];    
	    for(int i = 1; i <= num; i++){
	        bits[i] = bits[i/2];
	        if(i%2 == 1) bits[i]++; 
	    }
	    return bits;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(-5)));
	}
	
}
