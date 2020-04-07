/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00135_Candy {
	public static void main(String[] args) {
		int[] ratings = { 1, 0, 2 };
		P00135_Candy solution = new P00135_Candy();
		int total = solution.candy(ratings);
		System.out.println(total);
		ratings = new int[] { 1, 2, 2 };
		total = solution.candy(ratings);
		System.out.println(total);
	}

	public int candy(int[] ratings) {
		int total = 0;
		if (ratings == null || ratings.length == 0) {
			return total;
		}
		int[] candies = new int[ratings.length];
		candies[0] = 1;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}
		total = candies[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			int current = 1;
			if (ratings[i] > ratings[i + 1]) {
				current = candies[i + 1] + 1;
			}
			total += Math.max(current, candies[i]);
			candies[i] = current;
		}
		return total;
	}

}
