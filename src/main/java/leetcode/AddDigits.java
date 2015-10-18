package leetcode;

/**
 * 题目说明:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Created by skywalker on 2015/10/18.
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    private static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        //新的数字(各位相加得到)
        int n = 0;
        while (num > 0) {
            n += num % 10;
            num /= 10;
        }
        return addDigits(n);
    }

    //但是上面的算法没有达到作者的进一步要求(虽然accepted):
    //Could you do it without any loop/recursion in O(1) runtime?
    //这个是NB的解法:
    /*int addDigits(int num) {
        if (num==0) {
            return 0;
        }
        int x = num % 9;
        return x == 0 ? 9 : x;
    }*/

}
