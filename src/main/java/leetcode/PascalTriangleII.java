package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角/帕斯卡三角
 * 返回指定行
 * @author skywalker
 *
 */
public class PascalTriangleII {

	//3ms
	private static List<Integer> getRow(int rowIndex) {
		//leetcode上的index从0开始
		++rowIndex;
		if (rowIndex < 1) {
			return Collections.emptyList();
		}
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		List<Integer> pre;
		for (int i = 2;i <= rowIndex;++i) {
			pre = result;
			result = new ArrayList<Integer>(rowIndex);
			result.add(1);
			for (int j = 1;j < i - 1;++j) {
				result.add(pre.get(j) + pre.get(j - 1));
			}
			result.add(1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getRow(5));
	}
	
}
