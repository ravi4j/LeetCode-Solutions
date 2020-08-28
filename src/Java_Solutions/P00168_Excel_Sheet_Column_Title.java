/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00168_Excel_Sheet_Column_Title {
	public static void main(String[] args) {
		P00168_Excel_Sheet_Column_Title solution = new P00168_Excel_Sheet_Column_Title();
		int num = 1;
		String result = solution.convertToTitle(num);
		System.out.println(result);
		num = 28;
		result = solution.convertToTitle(num);
		System.out.println(result);
		num = 701;
		result = solution.convertToTitle(num);
		System.out.println(result); // ZY
	}

	public String convertToTitle(int n) {
		if (n <= 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			char ch = (char) ((n % 26) + 'A');
			sb.append(ch);
			n /= 26;
		}
		return sb.reverse().toString();
	}
}
