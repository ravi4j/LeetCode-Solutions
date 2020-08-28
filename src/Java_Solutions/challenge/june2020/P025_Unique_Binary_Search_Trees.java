/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P025_Unique_Binary_Search_Trees {
	public static void main(String[] args) {
		P025_Unique_Binary_Search_Trees solution = new P025_Unique_Binary_Search_Trees();
		int n = 3;
		int result = solution.numTrees(n);
		System.out.println(result); // 5
	}

	public int numTrees(int n) {
		int[] trees = new int[n + 1];
		trees[0] = 1;
		trees[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				trees[i] += trees[j] * trees[i - j - 1];
			}
		}
		return trees[n];
	}

}
