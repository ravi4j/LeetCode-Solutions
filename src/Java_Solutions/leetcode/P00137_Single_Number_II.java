package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00137_Single_Number_II {
	public static void main(String[] args) {
		int[] input = { 2, 2, 3, 2 };
		P00137_Single_Number_II solution = new P00137_Single_Number_II();
		int unique = solution.singleNumber(input);
		System.out.println(unique);
		int[] input2 = { 0, 1, 0, 1, 0, 1, 99 };
		unique = solution.singleNumber(input2);
		System.out.println(unique);
	}

	public int singleNumber(int[] nums) {
		int highBit = 0, lowBit = 0;
		for (int i = 0; i < nums.length; i++) {
			lowBit = ~highBit & (lowBit ^ nums[i]);
			highBit = ~lowBit & (highBit ^ nums[i]);
		}
		return lowBit;
	}
}
