package leetcode;

/**
 * 只允许一次交易
 * @author skywalker
 *
 */
public class BestTimetoBuyandSellStock {

	/*
	 * 2ms / O(n)
	 */
	private static int maxProfit(int[] prices) {
		int length;
		if (prices == null || (length = prices.length) < 2) {
			return 0;
		}
		int buy, sell, profit = 0;
		buy = sell = prices[0];
		for (int i = 1;i < length; ++i) {
			if (prices[i] > sell) {
				sell = prices[i];
			} else if (prices[i] <= buy) {
				profit = sell - buy > profit ? sell - buy : profit;
				buy = sell = prices[i];
			}
		}
		return sell - buy > profit ? sell - buy : profit;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] {3, 2, 3, 6, 4, 1, 9, 2, 4}));
		System.out.println(maxProfit(new int[] {1, 2, 3, 4, 8}));
		System.out.println(maxProfit(new int[] {3, 2, 1}));
		System.out.println(maxProfit(new int[] {2, 4, 1}));
		System.out.println(maxProfit(new int[] {1}));
		System.out.println(maxProfit(new int[] {}));
		System.out.println(maxProfit(null));
	}
	
}
