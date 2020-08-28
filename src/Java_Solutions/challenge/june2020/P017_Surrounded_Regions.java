/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.Arrays;

public class P017_Surrounded_Regions {
	public static void main(String[] args) {
		P017_Surrounded_Regions solution = new P017_Surrounded_Regions();
		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solution.solve(board);
		System.out.println(Arrays.deepToString(board));
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				dfs(board, i, 0);
			}
			if (board[i][n - 1] == 'O') {
				dfs(board, i, n - 1);
			}
		}

		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'O') {
				dfs(board, 0, i);
			}
			if (board[m - 1][i] == 'O') {
				dfs(board, m - 1, i);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] grid, int x, int y) {
		// check boundary condition
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 'O') {
			return;
		}
		// Marked visited
		grid[x][y] = '#';
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
