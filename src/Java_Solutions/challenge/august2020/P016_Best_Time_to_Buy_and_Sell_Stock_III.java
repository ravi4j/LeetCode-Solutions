/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.august2020;

public class P016_Best_Time_to_Buy_and_Sell_Stock_III {
	public static void main(String[] args) {
		P016_Best_Time_to_Buy_and_Sell_Stock_III solution = new P016_Best_Time_to_Buy_and_Sell_Stock_III();
		int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
		int result = solution.maxProfit(prices);
		System.out.println(result); //6

		prices = new int[] { 1, 2, 3, 4, 5 };
		result = solution.maxProfit(prices);
		System.out.println(result); // 4

		prices = new int[] { 7, 6, 4, 3, 1 };
		result = solution.maxProfit(prices);
		System.out.println(result); // 0
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int firstBuy = Integer.MIN_VALUE;
		int firstSell = 0;
		int secondBuy = Integer.MIN_VALUE;
		int secondSell = 0;
		for (int i = 0; i < prices.length; i++) {
			firstBuy = Math.max(firstBuy, -prices[i]);
			firstSell = Math.max(firstSell, firstBuy + prices[i]);
			secondBuy = Math.max(secondBuy, firstSell - prices[i]);
			secondSell = Math.max(secondSell, secondBuy + prices[i]);
		}
		return secondSell;
	}
}
