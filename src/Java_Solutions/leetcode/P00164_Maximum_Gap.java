package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00164_Maximum_Gap {
	public static void main(String[] args) {
		P00164_Maximum_Gap solution = new P00164_Maximum_Gap();
		int[] nums = new int[] { 100, 3, 2, 1 };
		int maxGap = solution.maximumGap(nums);
		System.out.println(maxGap);

		nums = new int[] { 10 };
		maxGap = solution.maximumGap(nums);
		System.out.println(maxGap);

		nums = new int[] { 3, 9, 2, 1 };
		maxGap = solution.maximumGap(nums);
		System.out.println(maxGap);

		nums = new int[] { 1, 1, 1, 1 };
		maxGap = solution.maximumGap(nums);
		System.out.println(maxGap);
	}

	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int n = nums.length;
		int min = nums[0];
		int max = nums[0];
		for (int i = 0; i < n; i++) {
			min =  Math.min(min , nums[i]);
			max = Math.max(max , nums[i]);
		}

		Bucket[] buckets = new Bucket[n + 1];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}
		// fill buckets
		int gap = (int) Math.ceil(((double) (max - min) / (n - 1)));
		for (int i = 0; i < n; i++) {
			int idx = gap != 0 ? (nums[i] - min) / gap : 0;
			buckets[idx].min = Math.min(nums[i], buckets[idx].min);
			buckets[idx].max = Math.max(nums[i], buckets[idx].max);
		}
		// scan buckets
		int maxGap = gap;
		int prev = min;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i].min == Integer.MAX_VALUE && buckets[i].max == Integer.MIN_VALUE) {
				// empty bucket
				continue;
			}
			maxGap = Math.max(maxGap, buckets[i].min - prev);
			prev = buckets[i].max;
		}
		//maxGap = Math.max(maxGap, max - prev);
		return maxGap;
	}

	private class Bucket {
		int min;
		int max;

		public Bucket() {
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
		}
	}
}
