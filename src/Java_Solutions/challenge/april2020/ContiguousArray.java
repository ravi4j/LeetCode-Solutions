/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		ContiguousArray solution = new ContiguousArray();
		int[] nums = new int[] { 0, 1 };
		int result = solution.findMaxLength(nums);
		System.out.println(result);

		nums = new int[] { 0, 1, 0 };
		result = solution.findMaxLength(nums);
		System.out.println(result);

		nums = new int[] { 0, 0, 1, 0, 0, 0, 1, 1 };
		result = solution.findMaxLength(nums);
		System.out.println(result);
	}

	public int findMaxLength(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Map<Integer, Integer> countMap = new HashMap<>();
		countMap.put(0, -1);

		int count = 0;
		int maxSubArrayLength = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i] == 1 ? 1 : -1;
			if (countMap.containsKey(count)) {
				maxSubArrayLength = Math.max(maxSubArrayLength, i - countMap.get(count));
			} else {
				countMap.put(count, i);
			}
		}
		return maxSubArrayLength;
	}

}
