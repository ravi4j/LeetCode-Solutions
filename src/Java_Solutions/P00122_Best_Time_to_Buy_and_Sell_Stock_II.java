/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00122_Best_Time_to_Buy_and_Sell_Stock_II {
	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		P00122_Best_Time_to_Buy_and_Sell_Stock_II solution = new P00122_Best_Time_to_Buy_and_Sell_Stock_II();
		int profit = solution.maxProfit(prices);
		System.out.println(profit);
		prices = new int[] { 1, 2, 3, 4, 5 };
		profit = solution.maxProfit(prices);
		System.out.println(profit);
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}

}
