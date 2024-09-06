package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.Arrays;

public class P00167_Two_Sum_II_Input_array_is_sorted {

	public static void main(String[] args) {
		P00167_Two_Sum_II_Input_array_is_sorted solution = new P00167_Two_Sum_II_Input_array_is_sorted();
		int[] numbers = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] result = solution.twoSum(numbers, target);
		System.out.println(Arrays.toString(result));
	}

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
			return null;
		}
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (target < sum) {
				j--;
			} else if (target > sum) {
				i++;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		return null;
	}
}
