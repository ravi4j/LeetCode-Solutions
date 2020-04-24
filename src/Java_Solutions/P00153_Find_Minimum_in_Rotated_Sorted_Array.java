/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00153_Find_Minimum_in_Rotated_Sorted_Array {
	public static void main(String[] args) {
		P00153_Find_Minimum_in_Rotated_Sorted_Array solution = new P00153_Find_Minimum_in_Rotated_Sorted_Array();
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int result = solution.findMin(nums);
		System.out.println(result);

		nums = new int[] { 9, 1,2,4,5,6,7 };
		result = solution.findMin(nums);
		System.out.println(result);
	}

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			if (nums[left] <= nums[right]) {
				return nums[left];
			}
			int mid = left + (right - left) / 2;
			if (nums[mid] >= nums[left]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return -1;
	}
}
