/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P00127_Word_Ladder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		P00127_Word_Ladder solution = new P00127_Word_Ladder();
		int length = solution.ladderLength(beginWord, endWord, wordList);
		System.out.println(length);
		beginWord = "hit";
		endWord = "cog";
		wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		length = solution.ladderLength(beginWord, endWord, wordList);
		System.out.println(length);
	}

	public int ladderLengthTimeLimitExceeds(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> wordSet = new HashSet<>(wordList);
		if (!wordSet.contains(endWord)) {
			return 0;
		}
		LinkedList<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(beginWord, 1));
		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			if (top.word.equals(endWord)) {
				return top.seq;
			}
			char[] chArray = word.toCharArray();
			for (int i = 0; i < chArray.length; i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char temp = chArray[i];
					if (chArray[i] != ch) {
						chArray[i] = ch;
					}
					String newWord = String.valueOf(chArray);
					if (wordSet.contains(newWord)) {
						queue.add(new WordNode(newWord, top.seq + 1));
						wordList.remove(newWord);
					}
					chArray[i] = temp;
				}
			}
		}
		return 0;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		LinkedList<WordNode> queue = new LinkedList<>();
		queue.add(new WordNode(beginWord, 1));
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;
			if (top.word.equals(endWord)) {
				return top.seq;
			}
			char[] chArray = word.toCharArray();
			for (int i = 0; i < chArray.length; i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char temp = chArray[i];
					if (chArray[i] != ch) {
						chArray[i] = ch;
					}
					String newWord = String.valueOf(chArray);
					if (wordSet.contains(newWord) && !visited.contains(newWord)) {
						queue.add(new WordNode(newWord, top.seq + 1));
						wordList.remove(newWord);
						visited.add(newWord);
					}
					chArray[i] = temp;
				}
			}
		}
		return 0;
	}

}

class WordNode {
	String word;
	int seq;

	public WordNode(String word, int seq) {
		this.seq = seq;
		this.word = word;
	}
}
