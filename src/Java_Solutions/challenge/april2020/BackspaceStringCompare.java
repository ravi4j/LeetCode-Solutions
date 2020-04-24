/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		BackspaceStringCompare solution = new BackspaceStringCompare();
		String S = "ab#c";
		String T = "ad#c";
		boolean result = solution.backspaceCompare(S, T);
		System.out.printf("%s %s : %b \n", S, T, result);

		S = "ab##";
		T = "c#d#";
		result = solution.backspaceCompare(S, T);
		System.out.printf("%s %s : %b \n", S, T, result);

		S = "a##c";
		T = "#a#c";
		result = solution.backspaceCompare(S, T);
		System.out.printf("%s %s : %b \n", S, T, result);

		S = "a#c";
		T = "b";
		result = solution.backspaceCompare(S, T);
		System.out.printf("%s %s : %b \n", S, T, result);

	}

	// We can solve it with stack as well but then it takes O(N) Space.
	public boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1;
		int j = T.length() - 1;
		int skipS = 0;
		int skipT = 0;
		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (S.charAt(i) == '#') {
					skipS++;
					i--;
				} else if (skipS > 0) {
					skipS--;
					i--;
				} else {
					break;
				}
			}

			while (j >= 0) {
				if (T.charAt(j) == '#') {
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				} else {
					break;
				}
			}

			if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
				return false;
			}

			if (i >= 0 && j < 0 || i < 0 && j >= 0) {
				return false;
			}

			i--;
			j--;
		}
		return true;
	}

}
