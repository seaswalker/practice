package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 举个栗子:
 * 1. pattern = "abba", str = "dog cat cat dog" should return true.
 * 2. pattern = "abba", str = "dog cat cat fish" should return false.
 * 3. pattern = "aaaa", str = "dog cat cat dog" should return false.
 * 4. pattern = "abba", str = "dog dog dog dog" should return false.
 * @author skywalker
 *
 */
public class WordPattern {

	//3ms
	private static boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) {
			return false;
		}
		char[] cs = pattern.toCharArray();
		String[] strs = str.split(" ");
		int l = cs.length;
		//元素个数不一致必定不匹配
		if (l != strs.length) {
			return false;
		}
		//记录patern-str对应关系
		Map<Character, String> map = new HashMap<Character, String>();
		char c;
		//pre: 如果pattern为ab，那么对应的两个字符串应该是不想等的
		String pre = null, s;
		for (int i = 0;i < l; ++i) {
			c = cs[i];
			s = strs[i];
			if (map.containsKey(c)) {
				if (!map.get(c).equals(s)) {
					return false;
				}
			} else {
				if (s.equals(pre)) {
					return false;
				} else {
					map.put(c, s);
					pre = s;
				}
			}
		}
		return true;
	} 
	
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}
	
}
