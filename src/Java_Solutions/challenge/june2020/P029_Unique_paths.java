/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P029_Unique_paths {
	public static void main(String[] args) {
		P029_Unique_paths solution = new P029_Unique_paths();
		int m = 3;
		int n = 2;
		int result = solution.uniquePaths(m, n);
		System.out.println(result); // 3

		m = 7;
		n = 3;
		result = solution.uniquePaths(m, n);
		System.out.println(result); // 28

	}

	public int uniquePaths(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] dp = new int[m][n];

		// left column
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		// top row
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}
		//System.out.println(Arrays.deepToString(dp));
		return dp[m - 1][n - 1];
	}

}
