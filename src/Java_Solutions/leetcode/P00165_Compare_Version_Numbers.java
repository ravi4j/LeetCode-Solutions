package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00165_Compare_Version_Numbers {
	public static void main(String[] args) {
		P00165_Compare_Version_Numbers solution = new P00165_Compare_Version_Numbers();
		String version1 = "0.1";
		String version2 = "1.1";
		int result = solution.compareVersion(version1, version2); // -1
		System.out.println(result);

		version1 = "1.0.1";
		version2 = "1";
		result = solution.compareVersion(version1, version2);
		System.out.println(result); // 1

		version1 = "7.5.2.4";
		version2 = "7.5.3";
		result = solution.compareVersion(version1, version2);
		System.out.println(result); // -1

		version1 = "1.01";
		version2 = "1.001";
		result = solution.compareVersion(version1, version2);
		System.out.println(result); // 0 //Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”

		version1 = "1.0";
		version2 = "1.0.0";
		result = solution.compareVersion(version1, version2);
		System.out.println(result); //0

	}

	public int compareVersion(String version1, String version2) {
		String[] level1 = version1.split("\\.");
		String[] level2 = version2.split("\\.");

		int maxLength = Math.max(level1.length, level2.length);

		for (int i = 0; i < maxLength; i++) {

			Integer ver1 = i < level1.length ? Integer.parseInt(level1[i]) : 0;
			Integer ver2 = i < level2.length ? Integer.parseInt(level2[i]) : 0;

			Integer result = ver1.compareTo(ver2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}
}
