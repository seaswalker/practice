package leetcode;

import java.util.Arrays;

/**
 * 求n以内(不含n)的素数的个数
 * @author skywalker
 *
 */
@SuppressWarnings("unused")
public class CountPrimes {
	
	/**
	 * 线性筛素数法
	 * 此算法可以保证每个只被筛选一次，时间复杂度接近于线性，然而空间复杂度更高了
	 * 可以参考:
	 * @see http://blog.csdn.net/mysword/article/details/5122855
	 * @see http://blog.csdn.net/dinosoft/article/details/5829550
	 * 66ms???
	 */
	private static int improveAgain(int n) {
		if (n <= 2) {
			return 0;
		}
		boolean[] flags = new boolean[n];
		Arrays.fill(flags, true);
		int[] primes = new int[n];
		int pi = 0;
		for (int i = 2;i < n; ++i) {
			if (flags[i]) {
				primes[pi++] = i;
			}
			//当前数和比此素数小的素数的积一定不是素数
			int mul;
			for (int j = 0;j < pi && (mul = i * primes[j]) < n; ++j) {
				flags[mul] = false;
				if (i % primes[j] == 0) {
					break;
				}
			}
		}
		int count = 1;
		for (int i = 3;i < n; ++i) {
			if (flags[i]) {
				++count;
			}
		}
		return count;
	}
	
	/**
	 * 筛素数法(普通)
	 * 43ms
	 * 此算法的问题在于比如10， 2的倍数时筛选一次，5的倍数时又一次...
	 * 另外这个O(n)的辅助空间也是个问题，如果计算Integer.MAX_VALUE以内呢，此数组会占用2GB的内存(以byte计)
	 */
	private static int improve(int n) {
		if (n <= 2) {
			return 0;
		}
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);
		for (int i = 2;i < n; ++i) {
			if (primes[i]) {
				for (int j = i << 1;j < n;j += i) {
					primes[j] = false;
				}
			}
		}
		int count = 1;
		for (int i = 3;i < n; ++i) {
			if (primes[i]) {
				++count;
			}
		}
		return count;
	}

	/**
	 * 最基本的算法
	 * 输入1500000导致超时
	 */
	private static int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		int count = 1;
		for (int i = 3;i < n; ++i) {
			if (isPrime(i)) {
				++count;
			}
		}
		return count;
	}
	
	/**
	 * 是否是素数
	 * @param num > 2
	 */
	private static boolean isPrime(int num) {
		for (int i = 2, l = (int) Math.sqrt(num);i <= l; ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(improveAgain(100));
	}
	
}
