package leetcode;

/**
 * 判断两个字符串是否是相同的字母但顺序不同
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * "aacc", "ccac" -> false
 * Created by skywalker on 2015/10/20.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram(s, t));
    }

    /**
     * 算法思想:
     * 因为题目说了是小写字母，所以一共就26中可能，所以只要维持一个数组，s里面的加
     * t里面的减，最后有不是0的就false
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            int[] map = new int[26];
            for (int i = 0, l = s.length();i < l;++i) {
                ++map[s.charAt(i) - 'a'];
                --map[t.charAt(i) - 'a'];
            }
            //此处的界限是26，不是字符串的长度!!!
            for (int i = 0;i < 26;++i) {
                if (map[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
