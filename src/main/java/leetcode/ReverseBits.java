package leetcode;

/**
 * 反转二进制位, 举个栗子
 * given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 此题需要注意的是前面的0也要反转，而不是简单的反转非0
 * @author skywalker
 *
 */
public class ReverseBits {

	/**
	 * 反转
	 * 这就是最简单的写法，jdk已经实现了此方法!
	 * 3ms, jdk的实现看不懂
	 * @param n 可以被是为unsigned
	 */
	private static int reverseBits(int n) {
		return Integer.reverse(n);
	}
	
	/**
	 * 这个是真正的解法
	 * 3ms
	 * @see https://leetcode.com/discuss/27328/java-solution-and-optimization
	 * 至于改进，可以把32位的int分为4个byte缓存起来
	 */
	private static int solution(int n) {
		int result = 0;
		for (int i = 0;i < 32;++i) {
			result |= n & 1;
			//使用无符号右移(高位用0补齐，有符号补符号位)
			n >>>= 1;
			//从第1位移到32位需要移动31次，不是32次
			if (i < 31) {
				result <<= 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(reverseBits(1));
		System.out.println(solution(1));
	}
	
}
