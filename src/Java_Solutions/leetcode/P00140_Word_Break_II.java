package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P00140_Word_Break_II {
	public static void main(String[] args) {
		String input = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		P00140_Word_Break_II solution = new P00140_Word_Break_II();
		List<String> results = solution.wordBreak(input, wordDict);
		System.out.println(results);
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		List<String> result = new ArrayList<>();
		if (s == null || s.length() == 0 || !isbreakable(s, dict)) {
			return result;
		}
		helper(s, 0, new StringBuilder(), dict, result);
		return result;
	}

	public void helper(String s, int start, StringBuilder item, Set<String> dict, List<String> results) {

		if (start >= s.length()) {
			results.add(item.toString());
			return;
		}

		if (start != 0) {
			item.append(" ");
		}

		for (int i = start; i < s.length(); i++) {
			String temp = s.substring(start, i + 1);
			if (dict.contains(temp)) {
				item.append(temp);
				helper(s , i+1 , item , dict , results);
				item.delete(item.length() + start - i - 1 , item.length());
			}
		}
		if(start!=0) item.deleteCharAt(item.length()-1);
	}

	private boolean isbreakable(String s, Set<String> dict) {
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
}
