/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P00139_Word_Break {
	public static void main(String[] args) {
		String input = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		P00139_Word_Break solution = new P00139_Word_Break();
		boolean result = solution.wordBreak(input, wordDict);
		System.out.println(result);

		String input1 = "applepenapple";
		List<String> wordDict1 = Arrays.asList("apple", "pen");
		boolean result1 = solution.wordBreak(input1, wordDict1);
		System.out.println(result1);

		String input2 = "catsandog";
		List<String> wordDict2 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		boolean result2 = solution.wordBreak(input2, wordDict2);
		System.out.println(result2);

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		return workBreakWithDP(s, dict);
	}

	private boolean workBreakWithDP(String s, Set<String> dict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String subString = s.substring(j, i);
				if (dp[j] && dict.contains(subString)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	// Recursive Solution
	public boolean wordBreakRec(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		Map<String, Boolean> memory = new HashMap<>();
		boolean result = wordBreakRecursive(s, memory, dict);
		return result;
	}

	private boolean wordBreakRecursive(String s, Map<String, Boolean> memory, Set<String> dict) {
		if (memory.containsKey(s)) {
			return memory.get(s);
		}
		if (dict.contains(s)) {
			memory.put(s, true);
			return true;
		}
		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.substring(i)) && wordBreakRecursive(s.substring(0, i), memory, dict)) {
				memory.put(s, true);
				return true;
			}
		}
		memory.put(s, false);
		return false;
	}



}
