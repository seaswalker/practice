package leetcode;

/**
 * 二进制加法，栗子:
 * a = "11"
 * b = "1"
 * Return "100"
 * @author skywalker
 *
 */
public class AddBinary {

	/**
	 * 本想偷个懒，但是会溢出...
	 */
	private static String addBinary(String a, String b) {
		int ai = Integer.parseInt(a, 2);
		int bi = Integer.parseInt(b, 2);
		return Integer.toBinaryString(ai + bi);
	}
	
	//4ms
	private static String improve(String a, String b) {
		if (a == null || b == null) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		//进位
		int flag = 0;
		char[] aa = a.toCharArray(), ba = b.toCharArray();
		int ai = aa.length - 1, bi = ba.length - 1;
		char ac, bc;
		while (ai >= 0 && bi >= 0) {
			ac = aa[ai--];
			bc = ba[bi--];
			if (ac == '0' && bc == '0') {
				result.append(flag);
				flag = 0;
			} else if (ac == '1' && bc == '1') {
				result.append(flag);
				flag = 1;
			} else if (flag == 1) {
				result.append('0');
			} else {
				result.append('1');
			}
		}
		while (ai >= 0) {
			ac = aa[ai--];
			if (ac == '1') {
				result.append(flag == 1 ? '0' : '1');
			} else {
				result.append(flag);
				flag = 0;
			}
		}
		while (bi >= 0) {
			bc = ba[bi--];
			if (bc == '1') {
				result.append(flag == 1 ? '0' : '1');
			} else {
				result.append(flag);
				flag = 0;
			}
		}
		if (flag == 1) {
			result.append('1');
		}
		return result.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("1010", "1011"));
		System.out.println(improve("1010", "1011"));
	}
	
}
