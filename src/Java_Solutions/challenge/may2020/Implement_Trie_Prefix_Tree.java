/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class Implement_Trie_Prefix_Tree {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app"));     // returns true
	}

	private static class Trie {
		private TrieNode root;

		/**
		 * Initialize your data structure here.
		 */
		public Trie() {
			root = new TrieNode();
		}

		/**
		 * Inserts a word into the trie.
		 */
		public void insert(String word) {
			TrieNode p = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (p.arr[index] == null) {
					TrieNode temp = new TrieNode();
					p.arr[index] = temp;
					p = temp;
				} else {
					p = p.arr[index];
				}
			}
			p.isEnd = true;
		}

		/**
		 * Returns if the word is in the trie.
		 */
		public boolean search(String word) {
			TrieNode p = searchNode(word);
			if (p == null) {
				return false;
			} else {
				if (p.isEnd)
					return true;
			}
			return false;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode p = searchNode(prefix);
			if (p == null) {
				return false;
			} else {
				return true;
			}
		}

		private TrieNode searchNode(String s) {
			TrieNode p = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				int index = c - 'a';
				if (p.arr[index] != null) {
					p = p.arr[index];
				} else {
					return null;
				}
			}

			if (p == root)
				return null;

			return p;
		}
	}

	private static class TrieNode {
		TrieNode[] arr;
		boolean isEnd;

		// Initialize your data structure here.
		public TrieNode() {
			this.arr = new TrieNode[26];
		}

	}

}
