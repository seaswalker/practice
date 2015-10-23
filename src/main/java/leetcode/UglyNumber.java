package leetcode;

import java.util.Arrays;

/**
 * 判断给定的数字是否是ugly number
 * 定义: 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly 
 * while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * @author skywalker
 *
 */

@SuppressWarnings("unused")
public class UglyNumber {

	public static void main(String[] args) {
		System.out.println(better(7));
	}
	
	/**
	 * 这个是从别人那里看来的思路
	 * @see http://segmentfault.com/a/1190000003480992
	 * 如果是ugly number，那么对此数不停地除以2/3/5那么最后应该得到1
	 * 仅需2ms
	 */
	private static boolean better(int num) {
		if (num < 1) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		int r2 = num % 2, r3 = num % 3, r5 = num % 5;
		while (r2 == 0 || r3 == 0 || r5 == 0) {
			if (r2 == 0) {
				num /= 2;
			} else if (r3 == 0) {
				num /= 3;
			} else {
				num /= 5;
			}
			r2 = num % 2;
			r3 = num % 3;
			r5 = num % 5;
		}
		return num == 1;
	}
	
	/**
	 * 使用素数筛法判断素数
	 * 然而还是会超时，没啥用
	 */
	private static boolean isUglyImprove(int num) {
		if (num < 1) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		int l = num / 2;
		boolean[] primes = new boolean[l + 1];
		//奇数设为true
		for (int i = 1;i <= l;i += 2) {
			primes[i] = true;
		}
		//筛选出[2 - num / 2]的素数
		for (int i = 3;i <= l;++i) {
			if (primes[i]) {
				for (int j = i + i;j <= l;j += i) {
					primes[j] = false;
				}
			}
		}
		for (int i = 3;i <= l;++i) {
			if (primes[i] && num % i == 0 && i > 5) {
				return false;
			}
		}
		return true;
	}

	private static boolean isUgly(int num) {
		if (num < 1) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		for (int i = 2, n = num / 2;i <= n;++i) {
			if (num % i == 0 && isPrime(i)) {
				if (i > 5) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * [2 - num / 2]间的所有素数
	 * 此算法在num特别大(亿)的时候，result数组会导致堆空间耗尽从而出现java.lang.OutOfMemoryError: Java heap space
	 * 比如num是200000000(2亿)，那么数组的长度为1亿，也就是10的9次方，一个int是4B，此数组共需要4 X 10的9次方Byte的空间
	 * 而1MB是10的6次方B(约)，那么堆需要4000MB，也就是4GB，所以...
	 * 其实没必要求此数组，直接迭代就行了
	 * @param num 必定大于1
	 * @return
	 */
	@Deprecated
	private static int[] primes(int num) {
		int n = num / 2;
		int[] result = new int[n];
		result[0] = 2;
		int ptr = 1;
		for (int i = 3;i <= n;++i) {
			if (isPrime(i)) {
				result[ptr++] = i;
			}
		}
		return result;
	}

	/**
	 * 判断n是否是素数
	 * 此算法(时间复杂度为O(n * sqrt(n)))在输入905391974时超时
	 * 可以看到明显的卡顿
	 * @param n 大于2
	 * @return
	 */
	private static boolean isPrime(int n) {
		for (int i = 2, l = ((int) Math.sqrt(n)) + 1;i < l;++i) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
