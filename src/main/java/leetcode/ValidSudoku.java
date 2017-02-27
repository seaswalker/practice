package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 判断给定的二维数组是不是一个有效的数独，数独的规则:
 * 1. 每一行都是1-9的数字只出现一次 
 * 2. 每一列都是1-9的数字只出现一次 
 * 3. 九个数字组成的框里面也是1-9只出现一次
 * @author skywalker
 *
 */
public class ValidSudoku {

	/**
	 * O(n2)
	 * 9ms
	 */
	private static boolean isValidSudoku(char[][] board) {
		if (board == null) {
			return false;
		}
		int l = board.length;
		//检测每一行，每一列
		Set<Character> row, col;
		ArrayList<Set<Character>> cells = new ArrayList<Set<Character>>(9);
		for (int i = 0;i < l; ++i) {
			cells.add(new HashSet<Character>());
		}
		char c;
		//偏移量，
		int offset = 0;
		for (int i = 0;i < l; ++i) {
			row = new HashSet<Character>();
			col = new HashSet<Character>();
			//计算偏移量
			offset = i / 3 * 2;
			for (int j = 0;j < l; ++j) {
				c = board[j][i];
				if (c != '.' && !col.add(c)) {
					return false;
				}
				c = board[i][j];
				if (c != '.') {
					if (!row.add(c)) {
						return false;
					}
					if (!cells.get(i / 3 + j / 3 + offset).add(c)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = {
				"53..7....".toCharArray(),
				"6..195...".toCharArray(),
				".98....6.".toCharArray(),
				"8...6...3".toCharArray(),
				"4..8.3..1".toCharArray(),
				"7...2...6".toCharArray(),
				".6....28.".toCharArray(),
				"...419..5".toCharArray(),
				"....8..79".toCharArray()
		};
		System.out.println(isValidSudoku(board));
	}
	
}
