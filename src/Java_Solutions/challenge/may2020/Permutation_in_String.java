/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class Permutation_in_String {
	public static void main(String[] args) {
		Permutation_in_String solution = new Permutation_in_String();
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean result = solution.checkInclusion(s1, s2);
		System.out.println(result);

		s1 = "ab";
		s2 = "eidboaoo";
		result = solution.checkInclusion(s1, s2);
		System.out.println(result);

	}

	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() > s2.length()) {
			return false;
		}

		int[] freqS1 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			freqS1[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			int[] freqS2 = new int[26];
			for (int j = 0; j < s1.length(); j++) {
				freqS2[s2.charAt(i + j) - 'a']++;
			}

			if (isMatch(freqS1, freqS2)) {
				return true;
			}
		}
		return false;
	}

	private boolean isMatch(int[] f1, int[] f2) {
		for (int i = 0; i < f1.length; i++) {
			if (f1[i] != f2[i]) {
				return false;
			}
		}
		return true;
	}
}
