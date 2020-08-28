/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class Number_of_Islands {
	public static void main(String[] args) {
		Number_of_Islands solution = new Number_of_Islands();
		char[][] input = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		int result = solution.numIslands(input);
		System.out.println(result);

		input = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		result = solution.numIslands(input);
		System.out.println(result);

	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int x, int y) {
		// check boundary condition
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
			return;
		}
		// Marked visited
		grid[x][y] = 'X';
		// go left
		dfs(grid, x - 1, y);
		// go right
		dfs(grid, x + 1, y);
		// go up
		dfs(grid, x, y - 1);
		// go down
		dfs(grid, x, y + 1);
	}

}
