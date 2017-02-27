package leetcode;

/**
 * 是否是2的幂
 * @author skywalker
 *
 */
public class PowerofTwo {
	
	private static boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(32));
	}
	
}
