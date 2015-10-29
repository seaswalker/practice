package leetcode;

/**
 * 举个栗子:
 * Given s = "Hello World",
 * return 5.
 * @author skywalker
 *
 */
public class LengthofLastWord {

	//0ms
	private static int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}
		int length = 0;
		for (int i = s.length() - 1;i >= 0; --i) {
			if (length == 0) {
				if (s.charAt(i) != ' ') {
					++length;
				} else {
					continue;
				}
			} else {
				if (s.charAt(i) != ' ') {
					++length;
				} else {
					break;
				}
			}
		}
		return length;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world"));
	}
	
}
