/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.august2020;

public class P005_Add_and_Search_Word {
	public static void main(String[] args) {
		WordDictionary obj = new WordDictionary();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		System.out.println(obj.search("pad")); //-> false
		System.out.println(obj.search("bad")); //-> true
		System.out.println(obj.search(".ad")); //-> true
		System.out.println(obj.search("b..")); //-> true
	}
}

class WordDictionary {
	private TrieNode root;

	/**
	 * Initialize your data structure here.
	 */
	public WordDictionary() {
		this.root = new TrieNode();
	}

	/**
	 * Adds a word into the data structure.
	 */
	public void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			if (node.arr[index] == null) {
				TrieNode chNode = new TrieNode();
				node.arr[index] = chNode;
				node = chNode;
			} else {
				node = node.arr[index];
			}
		}
		node.isLeaf = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return dfs(root, word, 0);
	}

	private boolean dfs(TrieNode node, String word, int start) {
		if (node.isLeaf && start == word.length()) {
			return true;
		}
		if (start >= word.length()) {
			return false;
		}

		char ch = word.charAt(start);

		if (ch == '.') {
			boolean result = false;
			for (int i = 0; i < 26; i++) {
				if (node.arr[i] != null) {
					if (dfs(node.arr[i], word, start + 1)) {
						result = true;
						break;
					}
				}
			}
			if (result) {
				return true;
			}
		} else {
			int index = ch - 'a';
			if (node.arr[index] != null) {
				return dfs(node.arr[index], word, start + 1);
			} else {
				return false;
			}
		}
		return false;
	}

	private class TrieNode {
		TrieNode[] arr;
		boolean isLeaf;

		public TrieNode() {
			arr = new TrieNode[26];
		}
	}
}
