/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P008_3Sum {
	public static void main(String[] args) {
		P008_3Sum solution = new P008_3Sum();
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = solution.threeSum(nums);
		System.out.println(result); // [[-1, -1, 2], [-1, 0, 1]]
	}

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.EMPTY_LIST;
		}
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int n = nums.length - 1;
			int j = i + 1;
			int k = n;
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			while (j < k) {
				if (k < n && nums[k] == nums[k + 1]) {
					k--;
					continue;
				}
				int sum = nums[i] + nums[j] + nums[k];
				if (sum > 0) {
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					result.add(list);
					k--;
					j++;
				}
			}
		}
		return result;
	}
}
