/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P001_Arranging_Coins {
	public static void main(String[] args) {
		P001_Arranging_Coins solution = new P001_Arranging_Coins();
		int n = 5;
		int result = solution.arrangeCoins(n);
		System.out.println(result); // 2

		n = 8;
		result = solution.arrangeCoins(n);
		System.out.println(result); // 3
	}

	public int arrangeCoins(int n) {
		if (n == 0) {
			return 0;
		}
		long left = 0;
		long right = n / 2 + 1;
		while (left < right) {
			long mid = left + (right - left) / 2;
			long value = (mid + 1) * mid / 2;
			if (value == n) {
				return (int) mid;
			} else if (value < n) {
				left = mid + 1;
			} else if (value > n) {
				right = mid - 1;
			}
		}
		return (int) ((left + 1) * left / 2 <= n ? left : left - 1);
	}
}
