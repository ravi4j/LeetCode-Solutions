/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.august2020;

import java.util.HashMap;
import java.util.Map;

public class P014_Longest_Palindrome_Solution {
	public static void main(String[] args) {
		P014_Longest_Palindrome_Solution solution = new P014_Longest_Palindrome_Solution();
		String s = "abccccdd";
		int result = solution.longestPalindrome(s);
		System.out.println(result); //7

		s = "a";
		result = solution.longestPalindrome(s);
		System.out.println(result); //1

		s = "bb";
		result = solution.longestPalindrome(s);
		System.out.println(result); //2

	}

	public int longestPalindrome(String s) {
		Map<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			freq.merge(s.charAt(i), 1, Integer::sum);
		}
		int numChars = 0;
		boolean center = false;
		for (Character character : freq.keySet()) {
			int value = freq.get(character);
			numChars += (value / 2) * 2;
			if (!center && value % 2 == 1) {
				center = true;
				numChars += 1;
			}
		}
		return numChars;
	}

}
