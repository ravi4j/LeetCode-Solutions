/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

import java.util.HashMap;
import java.util.Map;

public class P007_Word_Pattern {
	public static void main(String[] args) {
		P007_Word_Pattern solution = new P007_Word_Pattern();
		String pattern = "abba";
		String str = "dog cat cat dog";
		boolean result = solution.wordPattern(pattern, str);
		System.out.println(result); // True

		pattern = "abba";
		str = "dog cat cat fish";
		result = solution.wordPattern(pattern, str);
		System.out.println(result); // False

		pattern = "aaaa";
		str = "dog cat cat fish";
		result = solution.wordPattern(pattern, str);
		System.out.println(result); // False

		pattern = "abba";
		str = "dog dog dog dog";
		result = solution.wordPattern(pattern, str);
		System.out.println(result); // False

	}

	public boolean wordPattern(String pattern, String str) {
		String[] arrayStr = str.split(" ");
		if (arrayStr.length != pattern.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (map.containsKey(ch)) {
				String value = map.get(ch);
				if (!value.equals(arrayStr[i])) {
					return false;
				}
			} else if (map.containsValue(arrayStr[i])) {
				return false;
			}
			map.put(ch, arrayStr[i]);
		}
		return true;
	}
}
