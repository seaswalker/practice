package leetcode;

/**
 * ==>> 完成:8ms
 * 可以把任意输入转为整数
 * 示例:
 * "" -> 0
 * "  12" -> 12
 * "  -0012a42" -> -12
 * "+-2" -> 0
 * "   - 321" -> 0
 * "-" -> 0
 * "2147483648" -> 2147483647
 * "-2147483649" -> -2147483648
 * "b123" -> 0
 * Created by skywalker on 2015/10/18.
 */
public class Atoi {

    public static void main(String[] args) {
        System.out.println(atoi("b123"));
    }

    private static int atoi(String str) {
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        char c;
        //是否找到了正负号或数字
        boolean flag = false;
        for (int i = 0, l = arr.length;i < l;i ++) {
            c = arr[i];
            if (flag) {
                if (c >= '0' && c <= '9') {
                    sb.append(c);
                    flag = true;
                } else {
                    break;
                }
            } else {
                if ((c >= '0' && c <= '9') || c == '+' || c == '-') {
                    sb.append(c);
                    flag = true;
                } else if (c == ' ') {
                    continue;
                } else {
                    break;
                }
            }
        }
        String result = sb.toString();
        //解决输入的字符串越界的问题
        try {
            return "".equals(result) || "-".equals(result) || "+".equals(result) ? 0 : Integer.parseInt(result);
        } catch (Exception e) {
            return result.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

}
