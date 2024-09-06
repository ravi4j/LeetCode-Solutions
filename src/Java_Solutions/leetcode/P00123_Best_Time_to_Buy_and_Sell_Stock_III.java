package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00123_Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		int[] input = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
		P00123_Best_Time_to_Buy_and_Sell_Stock_III solution = new P00123_Best_Time_to_Buy_and_Sell_Stock_III();
		int maxProfit = solution.maxProfit(input);
		System.out.println(maxProfit);
		input = new int[] { 1, 2, 3, 4, 5 };
		maxProfit = solution.maxProfit(input);
		System.out.println(maxProfit);
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int n = prices.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int leftMin = prices[0];
		left[0] = 0;
		for (int i = 1; i < n; i++) {
			leftMin = Math.min(leftMin , prices[i]);
			left[i] = Math.max(left[i-1], prices[i] - leftMin);
		}
		int rightMax = prices[n-1];
		right[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			rightMax = Math.max(rightMax , prices[i]);
			right[i] = Math.max(right[i+1], rightMax - prices[i]);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, left[i] + right[i]);
		}
		return max;
	}
}
