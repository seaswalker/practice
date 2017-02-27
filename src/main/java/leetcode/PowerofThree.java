package leetcode;

/**
 * 判断给定的数字是否是3的幂
 * @author skywalker
 *
 */
public class PowerofThree {

    public static boolean isPowerOfThree(int n) {
    	if (n < 1) return false;
        while (n > 1) {
        	if (n % 3 == 0) {
        		n /= 3;
        	} else {
        		return false;
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(isPowerOfThree(0));
	}
    
    /*
     * 有两种方式达到"不用循环或递归"的要求:
     * 1、1162261467是int范围内最大的3的幂，所以:
     * return n > 0 and 1162261467 % n == 0;
     * 2、其实可以把int内所有的3的幂列举出来:
     * power_list = [1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467]
       return n in power_list;
       --https://leetcode.com/discuss/80819/simple-solutions-without-recursion-iteration-time-and-space
     */
	
}
