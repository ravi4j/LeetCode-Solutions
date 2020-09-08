/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

import java.util.HashMap;
import java.util.Map;

public class P003_Repeated_Substring_Pattern {
	public static void main(String[] args) {
		P003_Repeated_Substring_Pattern solution = new P003_Repeated_Substring_Pattern();
		String s = "abab";
		boolean result = solution.repeatedSubstringPattern(s);
		System.out.println(result); // true

		s = "aba";
		result = solution.repeatedSubstringPattern(s);
		System.out.println(result); // false

		s = "abcabcabcabc";
		result = solution.repeatedSubstringPattern(s);
		System.out.println(result);

	}

	public boolean repeatedSubstringPattern(String s) {
		Map<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			freq.merge(s.charAt(i), 1, Integer::sum);
		}
		int count = 0;
		int gcd = -1;
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			gcd = gcd == -1 ? entry.getValue() : gcd(gcd, entry.getValue());
			count += entry.getValue();
		}
		int minSize = count / gcd;
		System.out.printf("%d %d %d", count, gcd, minSize);

		//STEP 3: Check if the minimum size is the same size of the original string. That means there are not repetitions.
		if (minSize == s.length()) {
			return false;
		}
		//STEP 4: Try to check multiples sub strings of the "minSize"
		String sub = s.substring(0, minSize);
		System.out.println(sub);
		StringBuilder sb = new StringBuilder();
		int temp = gcd;
		while (temp > 0) {
			sb.append(sub);
			temp--;
		}
		// STEP 5: If both strings are the same we are good and return true.
		if (sb.toString().equals(s)) {
			return true;
		}

		//STEP 6: ... however, if they are not, we can still try to check agains substrings of size of the GCD
		sub = s.substring(0, gcd);
		System.out.println("Step 6" + sub);
		sb = new StringBuilder();
		while (minSize > 0) {
			sb.append(sub);
			minSize--;
		}
		return sb.toString().equals(s); //if this doesn't equal the same string, so there are no way.

	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
