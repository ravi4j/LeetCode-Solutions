/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.Arrays;

public class P011_Sort_Colors {
	public static void main(String[] args) {
		P011_Sort_Colors solution = new P011_Sort_Colors();
		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
		solution.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int startIndex = 0;
		int endIndex = nums.length - 1;
		int currentIndex = 0;
		while (currentIndex <= endIndex) {
			if (nums[currentIndex] == 0) {
				swap(nums, startIndex, currentIndex);
				currentIndex++;
				startIndex++;
			} else if (nums[currentIndex] == 2) {
				swap(nums, endIndex, currentIndex);
				endIndex--;
			} else {
				currentIndex++;
			}
		}
	}

	private void swap(int[] nums, int index, int currentIndex) {
		int temp;
		temp = nums[index];
		nums[index] = nums[currentIndex];
		nums[currentIndex] = temp;
	}
}
