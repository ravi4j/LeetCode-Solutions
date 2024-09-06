package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.HashSet;
import java.util.Set;

public class P00128_Longest_Consecutive_Sequence {

	public static void main(String[] args) {
		int[] input = new int[] { 100, 4, 200, 1, 3, 2 };
		P00128_Longest_Consecutive_Sequence solution = new P00128_Longest_Consecutive_Sequence();
		int max = solution.longestConsecutive(input);
		System.out.println(max);
	}

	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>(nums.length);
		for (int element : nums) {
			set.add(element);
		}

		int max = 0;

		for (int element : nums) {
			int count = 1;
			int prev = element - 1;
			while (set.contains(prev)) {
				set.remove(prev);
				prev--;
				count++;
			}
			int next = element + 1;
			while (set.contains(next)) {
				set.remove(next);
				next++;
				count++;
			}
			max = Math.max(count, max);
		}
		return max;
	}

}
