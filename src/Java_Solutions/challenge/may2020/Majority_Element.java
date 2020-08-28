/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class Majority_Element {
	public static void main(String[] args) {
		Majority_Element solution = new Majority_Element();
		int[] nums = new int[] { 3, 2, 3 };
		int result = solution.majorityElement(nums);
		System.out.println(result);

		nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		result = solution.majorityElement(nums);
		System.out.println(result);

	}

	public int majorityElement(int[] nums) {
		int majorityNumber = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				majorityNumber = nums[i];
				count = 1;
			} else if (majorityNumber == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return majorityNumber;
	}
}
