package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.stream.IntStream;

public class P00269_Single_Number_III {
	public static void main(String[] args) {
		int[] input = { 1, 2, 1, 3, 2, 5 };
		P00269_Single_Number_III solution = new P00269_Single_Number_III();
		int[] unique = solution.singleNumber(input);
		IntStream.of(unique).forEach(i -> System.out.print(i + " "));
		System.out.println();
		int[] input2 = { 1, 1, 2, 2, 3, 3, 99, 100 };
		unique = solution.singleNumber(input2);
		IntStream.of(unique).forEach(i -> System.out.print(i + " "));
	}

	public int[] singleNumber(int[] nums) {
		int allXor = 0;

		for (int i = 0; i < nums.length; i++) {
			allXor ^= nums[i];
		}

		int mask = allXor & -allXor;
		int A = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((mask & nums[i]) == 0) {
				A ^= nums[i];
			}
		}
		int B = allXor ^ A;
		return new int[] { A, B };
	}
}
