package something;

import org.junit.Test;

/**
 * 从贴吧看到的三道面试题
 * @see http://tieba.baidu.com/p/4118301631
 * @author skywalker
 *
 */
public class TieBa {

	/**
	 * 三角形数阵,比如输入:{3, 5, 8},输出:
	 * 3 1 3 4 4 3 1 3
	 * 4 2 4 5 5 4 2
	 * 5 3 5 1 1 5
	 * 1 4 1 2 2
	 * 2 5 2 3
	 * 3 1 3
	 * 4 2
	 * 5
	 */
	@Test
	public void triangle() {
		int[] arr = {3, 5, 8};
		//行数
		int lines = arr[2], low = arr[0], high = arr[1], n = low;
		int[][] matrix = new int[lines][lines];
		//数字的行数
 		for (int i = 0;i < lines;++i) {
 			//每行数字的个数
 			for (int j = 0, l = lines - i;j < l;++j) {
 				matrix[i][j] = n % high == 0 ? high : n % high;
 				++n;
 			}
 		}
 		StringBuilder sb = new StringBuilder();
 		//打印matrix的转置矩阵
 		for (int i = 0;i < lines;++i) {
 			for (int j = 0, l = lines - i;j < l;++j) {
 				sb.append(matrix[j][i]).append(" ");
 			}
 			sb.replace(sb.length() - 1, sb.length(), "\n");
 		}
 		System.out.println(sb.toString());
	}
	
	/**
	 * 第二道题感觉是这样的:
	 * 如果1在自己的位置上，那么结果是后面不在自己位置上的人数 + 1
	 * 如果不在，是1的下标 + 1
	 */
	
}
