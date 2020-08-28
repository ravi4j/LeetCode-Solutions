/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P007_Island_Perimeter {
	public static void main(String[] args) {
		P007_Island_Perimeter solution = new P007_Island_Perimeter();
		int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		int result = solution.islandPerimeter(grid);
		System.out.println(result);
	}

	public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int land = 0;
		int edges = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					land++;
					if (i > 0 && grid[i - 1][j] == 1) {
						edges++;
					}
					if (j > 0 && grid[i][j - 1] == 1) {
						edges++;
					}
				}
			}

		}
		return land * 4 - edges * 2;
	}
}
