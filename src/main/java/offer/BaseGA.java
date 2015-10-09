package offer;

import org.junit.Test;

/**
 * 基本算法
 * @author skywalker
 *
 */
public class BaseGA {

	/**
	 * 剑指offer 58页，二维数组的问题
	 * 此二维数组从左到右、总上到下都是递增的，从里面查找数字
	 */
	@Test
	public void matrix() {
		int[][] matrix = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
		//从右上角开始查找，左下角也是一样的
		int row = 0;
		int column = 3;
		//被查找的数字
		int number = 7;
		while(row < 4 && column >= 0) {
			if(matrix[row][column] == number) {
				System.out.println((row + 1) + "行" + (column + 1) + "列");
				break;
			}else if(matrix[row][column] > number) {
				//比所找的数字大，排除掉当前列
				-- column;
			}else {
				//比所找的数字小，排除掉当前行
				++ row;
			}
		}
	}
	
	/**
	 * 把字符串中的空格换为%20
	 * 时间复杂度为O(n)
	 */
	@Test
	public void replaceSpace() {
		char[] orginArray = "helloworld".toCharArray();
		//找出空格的个数
		int spaceCount = 0;
		for(int i = 0;i < orginArray.length;++ i) {
			if(orginArray[i] == ' ') {
				++ spaceCount;
			}
		}
		if(spaceCount > 0) {
			//新数组的长度
			int newArrayLength = orginArray.length + spaceCount * 2;
			char[] newArray = new char[newArrayLength];
			//复制到新数组
			for(int i = 0, j = 0;i < orginArray.length; ++i) {
				if(orginArray[i] != ' ') {
					newArray[j ++] = orginArray[i];
				}else {
					newArray[j ++] = '%';
					newArray[j ++] = '2';
					newArray[j ++] = '0';
				}
			}
			System.out.println(new String(newArray));
			return;
		}
		System.out.println(new String(orginArray));
	}
	
}
