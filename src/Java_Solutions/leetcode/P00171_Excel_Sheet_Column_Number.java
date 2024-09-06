package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00171_Excel_Sheet_Column_Number {
	public static void main(String[] args) {
		P00171_Excel_Sheet_Column_Number solution = new P00171_Excel_Sheet_Column_Number();
		String title = "A";
		int result = solution.titleToNumber(title);
		System.out.println(result);

		title = "AB";
		result = solution.titleToNumber(title);
		System.out.println(result);

	}

	public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		int result = 0;
		for (char ch : s.toCharArray()) {
			result = (result * 26) + (ch - 'A') + 1;
		}
		return result;
	}
}
