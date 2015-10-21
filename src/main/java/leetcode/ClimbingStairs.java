package leetcode;

/**
 * 爬梯子，一个梯子需要爬n步到顶，每次可以爬1或2步，有多少种方案
 * 推算n从1到5的结果发现，有如下的规律:
 * 1 -> 1
 * 2 -> 2
 * 3 -> 3
 * 4 -> 5
 * 5 -> 8
 * 除了2和斐波那契数列不同，其它一样，所以此问题其实就是求解"斐波那契数列"
 * Created by skywalker on 2015/10/21.
 */
@SuppressWarnings("unused")
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsImprove(44));
    }

	private static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n > 2) {
            return climbStairs(n - 1) + climbStairs(n - 2);
        } else {
            return -1;
        }
    }

    /**
     * 上面最简单的算法性能很低，存在很多重复计算，在leetcode上44即会造成超时，
     * 自己运行可以看到明显的卡顿
     * 加入缓存后仅需1ms
     * @param n
     * @return
     */
    private static int climbStairsImprove(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n > 2) {
            int[] cache = new int[n + 1];
            cache[1] = 1;
            cache[2] = 2;
            return improve(n, cache);
        } else {
            return -1;
        }
    }

    /**
     * 辅助方法
     * @param n 此时的n > 2
     * @param cache 缓存对象
     * @return
     */
    private static int improve(int n, int[] cache) {
        int result;
        if (cache[n] > 0) {
            return cache[n];
        }
        result = improve(n - 1, cache) + improve(n - 2, cache);
        cache[n] = result;
        return result;
    }

}
