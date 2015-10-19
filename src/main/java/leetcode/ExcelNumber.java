package leetcode;

/**
 * Excel Sheet Column Number
 * Created by skywalker on 2015/10/19.
 */
public class ExcelNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("Z"));
    }

    private static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0, l = s.length();i < l;++i) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, l - i - 1);
        }
        return result;
    }

}
