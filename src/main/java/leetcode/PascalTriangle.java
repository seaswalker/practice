package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角/帕斯卡三角
 * @author skywalker
 *
 */
public class PascalTriangle {

	//1ms
	private static List<List<Integer>> generate(int numRows) {
		if (numRows < 1) {
			return Collections.emptyList();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
		int size;
		//pre，上一层
		List<Integer> pre, list;
		for (int i = 0;i < numRows;++i) {
			size = result.size();
			//第一层
			if (size == 0) {
				list = new ArrayList<Integer>(1);
				list.add(1);
			} else {
				pre = result.get(i - 1);
				list = new ArrayList<Integer>(i + 1);
				list.add(1);
				for (int j = 1;j < i;++j) {
					list.add(pre.get(j) + pre.get(j - 1));
				}
				list.add(1);
			}
			result.add(list);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(6));
	}
	
}
