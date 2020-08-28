/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.stream.IntStream;

public class Product_of_Array_Except_Self {
	public static void main(String[] args) {
		Product_of_Array_Except_Self solution = new Product_of_Array_Except_Self();
		int[] nums = new int[] { 1, 2, 3, 4 };
		int[] output = solution.productExceptSelf(nums);
		IntStream.of(output).forEach(i -> System.out.printf("% d", i));
		System.out.println();
		nums = new int[] { 1, 2, 3, 4 };
		output = solution.productExceptSelfSaveSpace(nums);
		IntStream.of(output).forEach(i -> System.out.printf("% d", i));
	}

	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int[] prefixProducts = new int[nums.length];
		int[] suffixProducts = new int[nums.length];
		prefixProducts[0] = 1;
		suffixProducts[nums.length - 1] = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			prefixProducts[i + 1] = nums[i] * prefixProducts[i];
		}
		for (int j = nums.length - 1; j > 0; j--) {
			suffixProducts[j - 1] = nums[j] * suffixProducts[j];
		}
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			output[i] = prefixProducts[i] * suffixProducts[i];
		}
		return output;
	}

	public int[] productExceptSelfSaveSpace(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int[] output = new int[nums.length];
		output[nums.length - 1] = 1;
		// suffix products directly store into output array
		for (int j = nums.length - 2; j >= 0; j--) {
			output[j] = output[j + 1] * nums[j + 1];
		}
		int prefixProduct = 1;
		for (int i = 0; i < nums.length; i++) {
			output[i] *= prefixProduct;
			prefixProduct *= nums[i];
		}
		return output;
	}

}
