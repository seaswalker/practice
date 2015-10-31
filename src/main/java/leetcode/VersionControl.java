package leetcode;

import beanchmark.BenchMark;
import beanchmark.TimeBenchMark;

/**
 * 找出第一个不合格的版本
 * @author skywalker
 *
 */
public class VersionControl {
	
	@BenchMark(times = 50)
	public int improveTest() {
		return improve(2126753390);
	}
	
	/**
	 * 30ms
	 * O(logn)
	 * 运用二分查找的思想
	 */
	private static int improve(int n) {
		return recursive(1, n);
	}
	
	private static int recursive(int low, int high) {
		if (low >= high) {
			return low;
		}
		int mid = low + (high - low >>> 1);
		if (isBadVersion(mid)) {
			if (!isBadVersion(mid - 1)) {
				return mid;
			}
			return recursive(low, mid - 1);
		} else {
			if (isBadVersion(mid + 1)) {
				return mid + 1;
			}
			return recursive(mid + 1, high);
		}
	}
	
	@BenchMark(times = 50)
	public int firstBadVersionTest() {
		return firstBadVersion(2126753390);
	}
	
	/**
	 * 最简单的版本
	 * 当2126753390 versions，1702766719 is the first bad version时超时
	 */
	private static int firstBadVersion(int n) {
		while (isBadVersion(n)) {
			--n;
		}
		return n + 1;
	}

	private static boolean isBadVersion(int n) {
		return n >= 1702766719;
	}
	
	public static void main(String[] args) {
		TimeBenchMark.run(VersionControl.class);
	}
	
}
