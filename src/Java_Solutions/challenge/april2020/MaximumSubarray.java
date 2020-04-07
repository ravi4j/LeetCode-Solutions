/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray solution = new MaximumSubarray();
		int max = solution.maxSubArray(input);
		System.out.println(max);

		int[] input1 = { -2, -5, 6, -2, -3, 1, 5, -6 };
		int max1 = solution.maxSubArray(input1);
		System.out.println(max1);

		int[] input2 = { 2, 3, 4, 5, 7 };
		int max2 = solution.maxSubArray(input2);
		System.out.println(max2);

	}

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		return maxSubArray(nums, 0, nums.length - 1);
	}

	public int maxSubArray(int[] nums, int low, int high) {
		if (high == low) {
			return nums[high];
		}
		int mid = (high + low) / 2;
		int leftSubArrayMaxSum = maxSubArray(nums, low, mid);
		int rightSubArrayMaxSum = maxSubArray(nums, mid + 1, high);
		int maxSubArrayWithMidIncluded = maxCrossingSubArray(nums, low, mid, high);
		return Math.max(Math.max(leftSubArrayMaxSum, rightSubArrayMaxSum), maxSubArrayWithMidIncluded);
	}

	public int maxCrossingSubArray(int[] nums, int low, int mid, int high) {

		int sum = 0;
		int leftSum = Integer.MIN_VALUE;
		for (int i = mid; i >= low; i--) {
			sum += nums[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= high; i++) {
			sum += nums[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}
		return (leftSum + rightSum);
	}

}
