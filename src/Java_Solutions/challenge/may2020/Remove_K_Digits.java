/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class Remove_K_Digits {

	public static void main(String[] args) {
		Remove_K_Digits solution = new Remove_K_Digits();
		String num = "1432219";
		int k = 3;

		String result = solution.removeKdigits(num, k);
		System.out.println(result);

		num = "10200";
		k = 1;
		result = solution.removeKdigits(num, k);
		System.out.println(result);

		num = "10";
		k = 2;
		result = solution.removeKdigits(num, k);
		System.out.println(result);

		num = "112";
		k = 1;
		result = solution.removeKdigits(num, k);
		System.out.println(result);

		num = "5337";
		k = 2;
		result = solution.removeKdigits(num, k);
		System.out.println(result);

	}

	public String removeKdigits(String num, int k) {

		if (num == null || num.length() <= k) {
			return "0";
		}

		StringBuilder sb = new StringBuilder(num);
		for (int i = 0; i < k; i++) {
			int j = 0;
			while (j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1)) {
				j++;
			}
			sb.delete(j, j + 1);
		}

		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.delete(0, 1);
		}

		if (sb.length() == 0) {
			return "0";
		}
		return sb.toString();
	}

}
