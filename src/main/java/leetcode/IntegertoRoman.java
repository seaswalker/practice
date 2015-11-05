package leetcode;

/**
 * 转为罗马数字
 * @author skywalker
 *
 */
public class IntegertoRoman {

	/**
	 * 8ms
	 * @param num 范围1-3999
	 */
	private static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int n;
		if (num >= 1000) {
			n = num / 1000;
			appender('M', ' ', ' ', n, sb);
			num -= n * 1000;
		}
		if (num >= 100) {
			n = num / 100;
			appender('C', 'D', 'M', n, sb);
			num -= n * 100;
		}
		if (num >= 10) {
			n = num / 10;
			appender('X', 'L', 'C', n, sb);
			num -= n * 10;
		}
		appender('I', 'V', 'X', num, sb);
		return sb.toString();
	}
	
	/**
	 * 转换一位数字， 以3999为例
	 * @param base C(100)
	 * @param five D(500)
	 * @param upper M(1000)
	 * @param n 此位数字
	 * @param sb 
	 */
	private static void appender(char base, char five, char upper, int n, StringBuilder sb) {
		if (n < 4) {
			while (n-- > 0) {
				sb.append(base);
			}
		} else if (n == 4) {
			sb.append(base).append(five);
		} else if (n < 9) {
			sb.append(five);
			while (n-- > 5) {
				sb.append(base);
			}
		} else {
			sb.append(base).append(upper);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("3999: " + intToRoman(3999));
		System.out.println("7: " + intToRoman(7));
		System.out.println("8: " + intToRoman(8));
		System.out.println("9: " + intToRoman(9));
		System.out.println("4: " + intToRoman(4));
		System.out.println("17: " + intToRoman(17));
	}
	
}
