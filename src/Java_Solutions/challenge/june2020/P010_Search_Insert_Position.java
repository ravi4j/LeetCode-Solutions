/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P010_Search_Insert_Position {
	public static void main(String[] args) {
		P010_Search_Insert_Position solution = new P010_Search_Insert_Position();
		int[] nums = new int[] { 1, 3, 5, 6 };
		int target = 5;
		int result = solution.searchInsert(nums, target);
		System.out.println(result); // 2

		nums = new int[] { 1, 3, 5, 6 };
		target = 2;
		result = solution.searchInsert(nums, target);
		System.out.println(result); // 1

		nums = new int[] { 1, 3, 5, 6 };
		target = 7;
		result = solution.searchInsert(nums, target);
		System.out.println(result); // 4

		nums = new int[] { 1, 3, 5, 6 };
		target = 0;
		result = solution.searchInsert(nums, target);
		System.out.println(result); // 0
	}

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}
}
