/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
	public static void main(String[] args) {
		Sort_Characters_By_Frequency solution = new Sort_Characters_By_Frequency();
		String s = "tree";
		String result = solution.frequencySort(s);
		System.out.println(result);

		s = "cccaaa";
		result = solution.frequencySort(s);
		System.out.println(result);

		s = "Aabb";
		result = solution.frequencySort(s);
		System.out.println(result);

	}

	public String frequencySort(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		Map<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			freqMap.merge(s.charAt(i), 1, Integer::sum);
		}
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});

		pq.addAll(freqMap.entrySet());
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> entry = pq.poll();
			for (int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
	}
}
