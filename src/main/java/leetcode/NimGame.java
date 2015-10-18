package leetcode;

/**
 * 拿石头问题
 * 其实仔细算一算可以发现如下规律:
 * 1-3: true
 * 4: false
 * 5-7:true
 * 8:false
 * Created by skywalker on 2015/10/18.
 */
public class NimGame {

    public static void main(String[] args) {
        System.out.println(canWin(9));
    }

    private static boolean canWin(int n) {
        //就这么简单
        return n % 4 != 0;
    }

}
