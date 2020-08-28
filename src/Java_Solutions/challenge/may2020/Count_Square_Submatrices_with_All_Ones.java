/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class Count_Square_Submatrices_with_All_Ones {
	public static void main(String[] args) {
		Count_Square_Submatrices_with_All_Ones solution = new Count_Square_Submatrices_with_All_Ones();
		int[][] input = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int result = solution.countSquaresDP(input);
		System.out.println(result); //15

		input = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		result = solution.countSquaresDP(input);
		System.out.println(result); //7
	}

	public int countSquares(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] sums = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
			}
		}
		printMatrix(sums);
		int ans = 0;
		for (int i = 1; i <= m; ++i)
			for (int j = 1; j <= n; ++j)
				for (int k = Math.min(m - i + 1, n - j + 1); k > 0; --k) {
					int sum = sums[i + k - 1][j + k - 1] - sums[i + k - 1][j - 1] - sums[i - 1][j + k - 1] + sums[i - 1][j - 1];
					if (sum == k * k) {
						ans += 1;
					}
				}

		return ans;
	}

	public int countSquaresDP(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] sizes = new int[m + 1][n + 1];
		int ans = 0;
		for (int i = 1; i <= m; ++i)
			for (int j = 1; j <= n; ++j) {
				if (matrix[i - 1][j - 1] == 1) {
					sizes[i][j] = Math.min(Math.min(sizes[i - 1][j - 1], sizes[i - 1][j]), sizes[i][j - 1]) + 1;
				}
				ans += sizes[i][j];
			}
		return ans;
	}

	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%d ", matrix[i][j]);
			}
			System.out.println("]");
		}
		System.out.println();
	}

}
