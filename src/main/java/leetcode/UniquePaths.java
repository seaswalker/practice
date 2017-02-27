package leetcode;

import beanchmark.BenchMark;

/**
 * 机器人从网格的左上角到右下角一共有多少种路径
 * @author skywalker
 *
 */
public class UniquePaths {
	
	/**
	 * 7719ms
	 */
	@BenchMark(times = 10)
	public void noCahce() {
		int m = 23, n = 12;
		System.out.println(slower(m, n));
	}
	
	private static int slower(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		} else {
			return slower(m - 1, n) + slower(m, n - 1);
		}
	}
	
	/**
	 * 1ms
	 */
	@BenchMark(times = 10)
	public void useCache() {
		System.out.println(uniquePaths(23, 12));
	}
	
	/**
	 * 1ms
	 * 机器人每次只能向下或向右走一步
	 * 网格数(m, n)最多100
	 * 或许还可以改进，cache[1][3]和cache[3][1]的结果是一样的...
	 * @param m m x n
	 * @param n
	 */
	private static int uniquePaths(int m, int n) {
		int[][] cahce = new int[m + 1][n + 1];
		return helper(m, n, cahce);
	}
	
	/**
	 * 使用缓存
	 * @param cache
	 */
	private static int helper(int m, int n, int[][] cache) {
		if (m == 1 || n == 1) {
			return 1;
		} else {
			int result = cache[m][n];
			if (result == 0) {
				result = helper(m - 1, n, cache) + helper(m, n - 1, cache);
				cache[m][n] = result;
			}
			return result;
		}
	}
	
	/**
	 * 别人的算法，这其实就是一个组合问题，走到右下角共需要m + n - 2步(n)，向下走需要n - 1步(k)，结果
	 * 其实就是C(k, n) ==>> n! / k!(n - k)!
	 * 一共有n步，哪一步都可以向下...
	 */
	private static int better(int m, int n) {
		int N = m + n - 2;
		int K = m - 1;
		double res = 1;
		for (int i = 1;i <= K; ++i) {
			res *= (double)(N - K + i) / (double)i;
		}
		return (int) Math.round(res);
	}
	
	public static void main(String[] args) {
		System.out.println(better(23, 12));
	}
	
}
