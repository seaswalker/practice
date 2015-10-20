package leetcode;

/**
 * 这个是Excel Number的反例，字母转数字
 * Created by skywalker on 2015/10/20.
 */
public class ExcelTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(703));
    }

    private static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        //余数
        int num;
        while (n > 0) {
            num = (n % 26 + 25) % 26;
            sb.append((char) (num + 'A'));
            n = (n - num) / 26;
        }
        return sb.reverse().toString();
    }

}
