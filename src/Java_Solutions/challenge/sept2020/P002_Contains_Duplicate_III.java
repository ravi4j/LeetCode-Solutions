/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

import java.util.HashMap;
import java.util.Map;

public class P002_Contains_Duplicate_III {
	public static void main(String[] args) {
		P002_Contains_Duplicate_III solution = new P002_Contains_Duplicate_III();
		int[] nums = new int[] { 1, 2, 3, 1 };
		int k = 3;
		int t = 0;
		boolean result = solution.containsNearbyAlmostDuplicate(nums, k, t);
		System.out.println(result); // true;

		nums = new int[] { 1, 0, 1, 1 };
		k = 1;
		t = 2;
		result = solution.containsNearbyAlmostDuplicate(nums, k, t);
		System.out.println(result); // true;

		nums = new int[] { 1, 5, 9, 1, 5, 9 };
		k = 2;
		t = 3;
		result = solution.containsNearbyAlmostDuplicate(nums, k, t);
		System.out.println(result); // false;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length <= 1) {
			return false;
		}
		if (t < 0) {
			return false;
		}
		long bucketWidth = (long) (t + 1);
		Map<Long, Long> dict = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long bucketId = getBucketId(nums[i], bucketWidth);
			if (dict.containsKey(bucketId)) {
				return true;
			}
			if (dict.containsKey(bucketId - 1) && Math.abs(dict.get(bucketId - 1) - nums[i]) < bucketWidth) {
				return true;
			}
			if (dict.containsKey(bucketId + 1) && Math.abs(dict.get(bucketId + 1) - nums[i]) < bucketWidth) {
				return true;
			}
			dict.put(bucketId, (long) nums[i]);
			if (i - k >= 0) {
				long oldBucketId = getBucketId((long) nums[i - k], bucketWidth);
				dict.remove(oldBucketId);
			}
		}
		return false;
	}

	private long getBucketId(long n, long w) {
		return n >= 0 ? n / w : n / w - 1;
	}
}
