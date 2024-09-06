package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P00126_Word_Ladder_II {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		P00126_Word_Ladder_II solution = new P00126_Word_Ladder_II();
		List<List<String>> paths = solution.findLadders(beginWord, endWord, wordList);
		paths.stream().forEach(l -> System.out.println(l));
		wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		paths = solution.findLadders(beginWord, endWord, wordList);
		paths.stream().forEach(l -> System.out.println(l));
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);
		Set<String> dict = new HashSet<>(wordList);
		List<List<String>> res = new ArrayList<>();
		if (!dict.contains(endWord)) {
			return res;
		}
		HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
		HashMap<String, Integer> distance = new HashMap<>();
		ArrayList<String> solution = new ArrayList<>();
		bfs(beginWord, endWord, dict, nodeNeighbors, distance);
		dfs(beginWord, endWord, nodeNeighbors, distance, solution, res);
		return res;
	}

	private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
			HashMap<String, Integer> distance) {
		for (String str : dict) {
			nodeNeighbors.put(str, new ArrayList<>());
		}

		LinkedList<String> queue = new LinkedList<>();
		queue.offer(start);
		distance.put(start, 0);
		while (!queue.isEmpty()) {
			boolean foundPath = false;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String current = queue.poll();
				int currentDistance = distance.get(current);
				ArrayList<String> adjacentNodes = getAdjacentNodes(current, dict);
				for (String adj : adjacentNodes) {
					nodeNeighbors.get(current).add(adj);
					if (!distance.containsKey(adj)) {
						distance.put(adj, currentDistance + 1);
						if (end.equals(adj)) {
							foundPath = true;
						} else {
							queue.offer(adj);
						}
					}
				}
			}
			if (foundPath) {
				break;
			}
		}
	}

	private void dfs(String current, String end, HashMap<String, ArrayList<String>> nodeNeighbors,
			HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
		solution.add(current);
		if (end.equals(current)) {
			res.add(new ArrayList<>(solution));
		} else {
			for (String next : nodeNeighbors.get(current)) {
				if (distance.get(next) == distance.get(current) + 1) {
					dfs(next, end, nodeNeighbors, distance, solution, res);
				}
			}
		}
		solution.remove(solution.size() - 1);
	}

	private ArrayList<String> getAdjacentNodes(String node, Set<String> dict) {
		ArrayList<String> res = new ArrayList<>();
		char charArray[] = node.toCharArray();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < charArray.length; i++) {
				if (charArray[i] == ch)
					continue;
				char temp = charArray[i];
				charArray[i] = ch;
				String newWord = String.valueOf(charArray);
				if (dict.contains(newWord)) {
					res.add(newWord);
				}
				charArray[i] = temp;
			}
		}
		return res;
	}

}
