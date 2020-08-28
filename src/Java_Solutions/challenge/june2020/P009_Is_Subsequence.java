/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P009_Is_Subsequence {
	public static void main(String[] args) {
		P009_Is_Subsequence solution = new P009_Is_Subsequence();
		String s = "abc";
		String t = "ahbgdc";
		boolean result = solution.isSubsequence(s, t);
		System.out.println(result);

		s = "axc";
		t = "ahbgdc";
		result = solution.isSubsequence(s, t);
		System.out.println(result);

	}

	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0) {
			return true;
		}
		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			if (s.charAt(j) == t.charAt(i)) {
				j++;
			}
			if (j == s.length()) {
				return true;
			}
		}
		return false;
	}
}
