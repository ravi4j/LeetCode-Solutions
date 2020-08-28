/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P021_Word_Search {
	public static void main(String[] args) {
		P021_Word_Search solution = new P021_Word_Search();
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean result = solution.exist(board, word);
		System.out.println(result); // true;

		board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		word = "SEE";
		result = solution.exist(board, word);
		System.out.println(result); // true;

		board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		word = "ABCB";
		result = solution.exist(board, word);
		System.out.println(result); // false

	}

	public boolean exist(char[][] board, String word) {
		boolean result = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(board, word, i, j, 0)) {
					result = true;
				}
			}
		}
		return result;
	}

	private boolean dfs(char[][] board, String word, int x, int y, int wordIndex) {
		int m = board.length;
		int n = board[0].length;
		if (x < 0 || y < 0 || x >= m || y >= n) {
			return false;
		}

		if (board[x][y] == word.charAt(wordIndex)) {
			char ch = board[x][y];
			board[x][y] = '#'; // visited
			if (wordIndex == word.length() - 1) {
				return true;
			} else if (dfs(board, word, x - 1, y, wordIndex + 1) || dfs(board, word, x + 1, y, wordIndex + 1) || dfs(board, word, x,
					y - 1, wordIndex + 1) || dfs(board, word, x, y + 1, wordIndex + 1)) {
				return true;
			}
			board[x][y] = ch;
		}
		return false;
	}
}
