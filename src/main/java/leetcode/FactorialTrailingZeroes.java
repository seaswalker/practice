package leetcode;

/**
 * 求给定数的阶乘的末尾有多少个0
 * 时间复杂度O(logn)
 * 算法的思路:
 * 零的个数就是n除以5的1, 2, 3, 4...次方的结果的和
 * 测试数据:
 * 30 -> 7
 * 50 -> 12
 * 15 -> 3
 * 1808548329 -> 452137076
 * Integer.MAX_VALUE -> 536870902
 * @author skywalker
 *
 */
public class FactorialTrailingZeroes {

	//2ms
	private static int trailingZeroes(int n) {
		int result = 0;
		int num;
		//5的13次方是最后一个未溢出的5的n次幂
		for (int i = 1;i < 14;++i){
			num = (int) Math.pow(5, i);
			if (n < num) {
				break;
			}
			result += n / num;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(Integer.MAX_VALUE));
	}
	
}
