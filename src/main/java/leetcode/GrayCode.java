package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 生成n位的格雷码，举个栗子:
 * given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * @author skywalker
 *
 */
public class GrayCode {
	
	/**
	 * 你的解法是根据格雷码的规则一个个算出来的，其实是有规律的...
	 * (n+1)位格雷码中的前2^n个码字等于n位格雷码的码字，按顺序书写，加前缀0 
     * (n+1)位格雷码中的后2^n个码字等于n位格雷码的码字，按逆序书写，加前缀1，可以参考
     * @see http://www.cnblogs.com/springfor/p/3889222.html
     * 还是举个栗子吧:
  	 * 2位格雷码:
  	 * 00
  	 * 01
  	 * 11
  	 * 10
  	 * 那么3位的格雷码首先是2位的格雷码正序前面加0:
  	 * 000
  	 * 001
  	 * 011
  	 * 010
  	 * 然后是倒序前面加1:
  	 * 110
  	 * 111
  	 * 101
  	 * 100
  	 * 综合起来就是3位的格雷码了，前面加的那个1，反应到10进制就是加了1 << (3 - 1)，而在前面加0其实在10进制上是没有意义的，
  	 * 这就解释了下面的算法...
	 * @param n
	 * @return
	 */
	private static List<Integer> better(int n) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int i = 0;i < n; ++i) {
			//加数
			int inc = 1 << i;
			//逆序
			for (int j = list.size() - 1;j >= 0; --j) {
				list.add(list.get(j) + inc);
			}
		}
		return list;
	}

	/**
	 * 7ms
	 * 解决思路摘自百度百科:
	 * 异或转换
 	 * 二进制码→格雷码（编码）：
	 * 此方法从对应的n位二进制码字中直接得到n位格雷码码字，步骤如下：
	 * 对n位二进制的码字，从右到左，以0到n-1编号
	 * 如果二进制码字的第i位和i+1位相同，则对应的格雷码的第i位为0，否则为1(当i+1=n时，二进制码字的第n位被认为是0，即第n-1位不变)
	 * 公式表示：  (G：格雷码，B：二进制码)
	 */
	private static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0) {
			list.add(0);
			return list;
		}
		char[] arr;
		for (int i = 0, l = 1 << n;i < l; ++i) {
			arr = helper(i, n);
			for (int j = n - 1;j > 0;--j) {
				arr[j] = arr[j] == arr[j - 1] ? '0' : '1';
			}
			//最高位和0异或
			arr[0] = arr[0] == '1' ? '1' : '0';
			list.add(Integer.parseInt(new String(arr), 2));
		}
		return list;
	}
	
	/**
	 * 把数字转为特定位数的字符数组
	 * @param n
	 * @param bits 位数
	 */
	private static char[] helper(int n, int bits) {
		char[] arr = new char[bits];
		Arrays.fill(arr, '0');
		char[] src = Integer.toBinaryString(n).toCharArray();
		System.arraycopy(src, 0, arr, bits - src.length, src.length);
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(grayCode(3));
		System.out.println(better(3));
	}
	
}
