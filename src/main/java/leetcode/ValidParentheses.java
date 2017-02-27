package leetcode;

import java.util.LinkedList;

/**
 * 有效的括号---栈的经典应用
 * @author skywalker
 *
 */
public class ValidParentheses {

	//1ms
	private static boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		LinkedList<Character> stack = new LinkedList<Character>();
		char[] arr = s.toCharArray();
		char c;
		for (int i = 0, l = arr.length;i < l; ++i) {
			c = arr[i];
			switch (c) {
				case '(':
				case '{':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
					break;
				case '}':
					if (!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
					break;
				case ']':
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
					break;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}
	
}
