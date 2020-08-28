/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P029_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	public static void main(String[] args) {
		P029_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown solution = new P029_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
		int[] prices = new int[] { 1, 2, 3, 0, 2 };
		int result = solution.maxProfit(prices);
		System.out.println(result);
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int buy1 = -prices[0];
		int sell2 = 0;
		int sell1 = 0;
		for (int i = 1; i <= prices.length; i++) {
			int buy0 = Math.max(buy1, sell2 - prices[i - 1]);
			int sell0 = Math.max(sell1, buy1 + prices[i - 1]);
			buy1 = buy0;
			sell2 = sell1;
			sell1 = sell0;
		}
		return sell1;
	}
}
