/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.LinkedHashMap;
import java.util.Map;

public class First_Unique_Character_in_a_String {

	public static void main(String[] args) {
		First_Unique_Character_in_a_String solution = new First_Unique_Character_in_a_String();
		String s = "leetcode";
		int index = solution.firstUniqChar(s);
		System.out.println(index);
		s = "loveleetcode";
		index = solution.firstUniqChar(s);
		System.out.println(index);
		s = "dddccdbba";
		index = solution.firstUniqChar(s);
		System.out.println(index);
	}

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		Map<Character, Integer> freqMap = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			freqMap.merge(s.charAt(i), 1, Integer::sum);
		}

		for (int i = 0; i < s.length(); i++) {
			if (freqMap.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
}
