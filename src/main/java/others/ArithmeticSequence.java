package others;

/**
 * 等差数列求和
 * @author skywalker
 *
 */
public class ArithmeticSequence {

	private static int a1 = 1;
	private static int d = 3;
	//和
	private static int result = 0;
	
	public static void main(String[] args) {
		sum(2);
		System.out.println(result);
	}
	
	/**
	 * 递归求和
	 * @param n项数
	 */
	private static void sum(int n) {
		if(n == 1) {
			result += a1;
		}else {
			result += (a1 + (n - 1) * d);
			sum(n - 1);
		}
	}
	
}
