/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P016_Top_K_Frequent_Elements {
	public static void main(String[] args) {
		P016_Top_K_Frequent_Elements solution = new P016_Top_K_Frequent_Elements();
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		int[] result = solution.topKFrequent(nums, k);
		System.out.println(Arrays.toString(result));

		nums = new int[] { 1 };
		k = 1;
		result = solution.topKFrequent(nums, k);
		System.out.println(Arrays.toString(result));
	}

	public int[] topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.merge(nums[i], 1, (a, b) -> a + b);
		}
		PriorityQueue<Freq> pq = new PriorityQueue<>((f1, f2) -> f2.freq - f1.freq);
		for (Integer key : map.keySet()) {
			pq.offer(new Freq(key, map.get(key)));
		}

		int[] result = new int[k];
		int i = 0;
		while (k > 0) {
			result[i++] = pq.poll().ele;
			k--;
		}
		return result;
	}

	private class Freq {
		int ele;
		int freq;

		public Freq(int ele, int fre) {
			this.ele = ele;
			this.freq = fre;
		}
	}
}
