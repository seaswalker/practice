package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断给定的两个字符串是否是同构的，举个栗子:
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * @author skywalker
 *
 */
public class IsomorphicStrings {

	/**
	 * 可以认为两个字符串是相同长度的
	 * 28ms
	 */
	private static boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		//每个字符第一次出现的下标
		Map<Character, Integer> smap = new HashMap<Character, Integer>();
		Map<Character, Integer> tmap = new HashMap<Character, Integer>();
		char[] sa = s.toCharArray(), ta = t.toCharArray();
		char sc, tc;
		for (int i = 0, l = sa.length;i < l; ++i) {
			sc = sa[i];
			tc = ta[i];
			if (smap.containsKey(sc)) {
				if (!tmap.containsKey(tc) || smap.get(sc) != tmap.get(tc)) {
					return false;
				}
			} else {
				if (tmap.containsKey(tc)) {
					return false;
				} else {
					smap.put(sc, i);
					tmap.put(tc, i);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
	}
	
}
