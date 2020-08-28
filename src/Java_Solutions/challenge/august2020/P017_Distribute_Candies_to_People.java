/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.august2020;

import java.util.Arrays;

public class P017_Distribute_Candies_to_People {
	public static void main(String[] args) {
		P017_Distribute_Candies_to_People solution = new P017_Distribute_Candies_to_People();
		int candies = 7;
		int numPeople = 4;
		int[] result = solution.distributeCandies(candies, numPeople);
		System.out.println(Arrays.toString(result)); // [1,2,3,1]

		candies = 10;
		numPeople = 3;
		result = solution.distributeCandies(candies, numPeople);
		System.out.println(Arrays.toString(result)); // [5, 2, 3]
	}

	public int[] distributeCandies(int candies, int num_people) {
		int[] result = new int[num_people];
		int gaveCandies = 1;
		while (candies > 0) {
			result[(gaveCandies - 1) % num_people] += Math.min(candies, gaveCandies);
			candies -= gaveCandies;
			gaveCandies++;
		}
		return result;
	}
}
