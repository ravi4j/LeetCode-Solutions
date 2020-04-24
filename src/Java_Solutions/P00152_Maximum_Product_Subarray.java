/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00152_Maximum_Product_Subarray {

	public static void main(String[] args) {
		P00152_Maximum_Product_Subarray solution = new P00152_Maximum_Product_Subarray();
		int[] input = new int[] { 2, 3, -2, 4 };
		int maxProduct = solution.maxProduct(input);
		System.out.println(maxProduct);

		input = new int[] { -2, 0, -1 };
		maxProduct = solution.maxProduct(input);
		System.out.println(maxProduct);

		input = new int[] { -2, 3, -4 };
		maxProduct = solution.maxProduct(input);
		System.out.println(maxProduct);
	}

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] minProduct = new int[nums.length];
		int[] maxProduct = new int[nums.length];
		minProduct[0] = nums[0];
		maxProduct[0] = nums[0];
		int bestProduct = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				maxProduct[i] = Math.max(nums[i], maxProduct[i - 1] * nums[i]);
				minProduct[i] = Math.min(nums[i], minProduct[i - 1] * nums[i]);
			} else {
				maxProduct[i] = Math.max(nums[i], minProduct[i - 1] * nums[i]);
				minProduct[i] = Math.min(nums[i], maxProduct[i - 1] * nums[i]);
			}
			bestProduct = Math.max(bestProduct, maxProduct[i]);
		}
		return bestProduct;
	}

}
