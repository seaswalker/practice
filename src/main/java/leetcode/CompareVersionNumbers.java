package leetcode;

/**
 * 比较版本号(最后一道Easy),栗子
 * 0.1和0.0.1
 * @author skywalker
 *
 */
public class CompareVersionNumbers {

	/**
	 * 时间复杂度O(n) / 1ms
	 * @param version1
	 * @param version2
	 * @return
	 */
	private static int compareVersion(String version1, String version2) {
		int f = 0, s = 0,
				fi = 0, si = 0,
				fl = version1.length(), sl = version2.length();
		char fc, sc;
		//比较公共长度部分
		while (fi < fl && si < sl) {
			while (fi < fl && (fc = version1.charAt(fi)) != '.') {
				f = f * 10 + (fc - '0');
				++fi;
			}
			while (si < sl && (sc = version2.charAt(si)) != '.') {
				s = s * 10 + (sc - '0');
				++si;
			}
			if (f > s) {
				return 1;
			} else if (f < s) {
				return -1;
			} else {
				f = s = 0;
				++fi;
				++si;
			}
		}
		while (fi < fl) {
			fc = version1.charAt(fi++);
			if (fc > '0' && fc <= '9') {
				return 1;
			}
		}
		while (si < sl) {
			sc = version2.charAt(si++);
			if (sc > '0' && sc <= '9') {
				return -1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(compareVersion("01", "1"));
	}
	
}
