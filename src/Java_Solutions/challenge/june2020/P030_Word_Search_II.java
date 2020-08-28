/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.ArrayList;
import java.util.List;

public class P030_Word_Search_II {
	public static void main(String[] args) {
		P030_Word_Search_II solution = new P030_Word_Search_II();
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = new String[] { "oath", "pea", "eat", "rain" };
		List<String> result = solution.findWords(board, words);
		System.out.println(result);

		board = new char[][] { { 'a', 'b' }, { 'c', 'd' } };
		words = new String[] { "ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb" };
		result = solution.findWords(board, words);
		System.out.println(result); //["ab","ac","bd","ca","db"]

	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> results = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, results);
			}
		}
		return results;
	}

	private void dfs(char[][] boards, int x, int y, TrieNode root, List<String> results) {
		char ch = boards[x][y];
		if (ch == '#' || root.next[ch - 'a'] == null) {
			return;
		}
		root = root.next[ch - 'a'];

		if (root.word != null) {
			results.add(root.word);
			root.word = null; // to avoid adding duplicate
		}

		boards[x][y] = '#'; // mark visited
		if (x > 0) {
			dfs(boards, x - 1, y, root, results);
		}
		if (x < boards.length - 1) {
			dfs(boards, x + 1, y, root, results);
		}
		if (y > 0) {
			dfs(boards, x, y - 1, root, results);
		}
		if (y < boards[0].length - 1) {
			dfs(boards, x, y + 1, root, results);
		}
		boards[x][y] = ch; // backtracked
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			TrieNode p = root;
			char[] chars = word.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				int index = chars[i] - 'a';
				if (p.next[index] == null) {
					p.next[index] = new TrieNode();
				}
				p = p.next[index];
			}
			p.word = word;
		}
		return root;
	}

	private class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
}
