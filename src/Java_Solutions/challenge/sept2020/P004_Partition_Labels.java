/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P004_Partition_Labels {
	public static void main(String[] args) {
		P004_Partition_Labels solution = new P004_Partition_Labels();
		String S = "ababcbacadefegdehijhklij"; // The partition is "ababcbaca", "defegde", "hijhklij".
		List<Integer> result = solution.partitionLabels(S);
		System.out.println(result); //[9, 7, 8]

		S = "ababfeefhijkh"; //  "abab", "feef", "hijkh"
		result = solution.partitionLabels(S);
		System.out.println(result); //[4, 4, 5]

	}

	// This is a range merge problem
	public List<Integer> partitionLabels(String S) {
		LinkedHashMap<Character, int[]> rangeMap = new LinkedHashMap<>();
		// build range
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			int[] range = rangeMap.getOrDefault(ch, new int[] { -1, -1 });
			if (range[0] == -1) {
				range[0] = i;
				range[1] = i;
			} else {
				range[1] = i;
			}
			rangeMap.put(ch, range);
		}
		// merge range
		int[] tempRange = null;
		List<Integer> results = new ArrayList<>();
		for (Map.Entry<Character, int[]> entry : rangeMap.entrySet()) {
			int[] currentRange = entry.getValue();
			if (tempRange == null) {
				tempRange = currentRange;
			} else {
				if (currentRange[0] < tempRange[1]) {
					tempRange = new int[] { tempRange[0], Math.max(currentRange[1], tempRange[1]) };
				} else {
					results.add(tempRange[1] - tempRange[0] + 1);
					tempRange = currentRange;
				}
			}
		}
		results.add(tempRange[1] - tempRange[0] + 1);
		return results;
	}
}
