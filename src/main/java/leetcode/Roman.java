package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转阿拉伯数字
 * Created by skywalker on 2015/10/21.
 */
public class Roman {

    /**
     * 保存罗马数字和int的对应关系
     */
    private static final Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI"));
    }

    private static int romanToInt(String s) {
        int result = 0, l = s.length();
        int slower = 0, faster = 1, fn, sn;
        while (slower < l) {
            fn = map.get(s.charAt(slower));
            sn = faster < l ? map.get(s.charAt(faster)) : 0;
            result += fn < sn ? 0 - fn : fn;
            ++slower;
            ++faster;
        }
        return result;
    }

}
