/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.Arrays;

public class P004_Reverse_String {
	public static void main(String[] args) {
		P004_Reverse_String solution = new P004_Reverse_String();
		char[] input = new char[] { 'h', 'e', 'l', 'l', 'o' };
		solution.reverseString(input);
		System.out.println(Arrays.toString(input));

		input = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
		solution.reverseString(input);
		System.out.println(Arrays.toString(input));

	}

	public void reverseString(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}
		int i = 0;
		int j = s.length - 1;
		while (i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

}
