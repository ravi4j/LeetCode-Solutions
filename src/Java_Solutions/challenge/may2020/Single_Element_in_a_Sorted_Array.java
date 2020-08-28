/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class Single_Element_in_a_Sorted_Array {
	public static void main(String[] args) {
		Single_Element_in_a_Sorted_Array solution = new Single_Element_in_a_Sorted_Array();
		int[] input = new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		int result = solution.singleNonDuplicate(input);
		System.out.println(result);

		input = new int[] { 3, 3, 7, 7, 10, 11, 11 };
		result = solution.singleNonDuplicate(input);
		System.out.println(result);
	}

	public int singleNonDuplicate(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == 0 || mid == nums.length - 1) {
				return nums[mid];
			}

			if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
				return nums[mid];
			} else {
				int firstMidValue = mid;
				if (nums[mid] == nums[mid - 1]) {
					firstMidValue = mid - 1;
				}
				int left_count = firstMidValue - low;
				if (left_count % 2 != 0) {
					high = firstMidValue - 1;
				} else {
					low = firstMidValue + 2;
				}
			}
		}
		return -1;
	}
}
