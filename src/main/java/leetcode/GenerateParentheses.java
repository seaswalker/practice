package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 匹配括号，举个栗子:
 * given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author skywalker
 *
 */
public class GenerateParentheses {

	private static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if (n < 1) {
			return list;
		}
		list.add("()");
		for (int i = 1;i < n; ++i) {
			int l = list.size() - 1;
			for (int j = 0;i < l; ++j) {
				list.add("(" + list.get(j) + ")");
				list.add("()" + list.get(j));
				list.add(list.get(j) + "()");
			}
			list.add("()" + list.get(l));
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}
	
}
