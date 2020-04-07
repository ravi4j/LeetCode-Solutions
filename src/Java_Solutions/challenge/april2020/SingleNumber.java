/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class SingleNumber {
	public static void main(String[] args) {
		SingleNumber solution = new SingleNumber();

		int[] nums = { 2, 2, 1 };
		int result = solution.singleNumber(nums);
		System.out.println(result);

		int[] nums1 = { 4, 1, 2, 1, 2 };
		result = solution.singleNumber(nums1);
		System.out.println(result);
	}

	public int singleNumber(int[] nums) {
		int x = 0;
		for (int a : nums) {
			x = x ^ a;
		}
		return x;
	}

}
