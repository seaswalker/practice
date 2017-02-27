package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Best Time to Buy and Sell Stock II
 * 测试数据:
 * null / {} / {3} -> 0
 * {7, 6, 5} -> 0
 * [2,1,2,0,1] -> 2
 * Created by skywalker on 2015/10/19.
 */
@SuppressWarnings("unused")
public class SellStockII {

    public static void main(String[] args) {
        //int[] arr = {7, 5, 3, 8, 9, 10, 8, 9, 11, 19};
        int[] arr = {2,1,2,0,1};
        System.out.println(best(arr));
    }

    /**
     * 时间复杂度O(N2)，超时
     * 并且答案是错误的
     * @param arr
     * @return
     */
    private static int cal(int[] arr) {
        int length;
        if (arr != null && (length = arr.length) > 0) {
            //利益
            int profit = Integer.MIN_VALUE, dir;
            for (int i = 0, l = length - 1;i < l;++i) {
                dir = Integer.MIN_VALUE;
                //寻找第i天购买的话可以得到的最大利益
                for (int j = i + 1;j < l + 1;++j) {
                    if (arr[j] - arr[i] > dir) {
                        dir = arr[j] - arr[i];
                    }
                }
                if (dir > profit) {
                    profit = dir;
                }
            }
            return profit;
        }
        return 0;
    }

    /**
     * 改进算法
     * 时间复杂度O(N)
     * 成绩: 4ms
     * @param prices
     * @return
     */
    private static int improve(int[] prices) {
        int length;
        if (prices != null && (length = prices.length) > 1) {
            int es = 0;
            int dir;
            //示例: 对于数据{2,1,2,0,1}，应该记录数据1, 1两个数据
            List<Integer> ups = new ArrayList<>();
            for (int i = 1;i < length;++i) {
                dir = prices[i] - prices[i - 1];
                if (dir > 0) {
                    es += dir;
                } else {
                    ups.add(es);
                    es = 0;
                }
            }
            if (ups.size() > 0) {
                for (int i : ups) {
                    es += i;
                }
                return es;
            } else if (es > 0) {
                return es;
            } else {
                //如果价格是递减的，那么就不买了(返回0)
                return 0;
            }
        }
        return 0;
    }

    /**
     * 这个才是最好的解法
     * @see  "https://leetcode.com/discuss/64499/pretty-simple-java-solution-6-lines-with-no-abbreviation"
     * @param prices
     * @return
     */
    private static int best(int[] prices) {
        int profit = 0, dir;
        if (prices != null) {
            for (int i = 1, l = prices.length;i < l;++i) {
                dir = prices[i] - prices[i - 1];
                profit += (dir > 0 ? dir : 0);
            }
        }
        return profit;
    }

}
