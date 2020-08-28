/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Possible_Bipartition {
	private Map<Integer, List<Integer>> graph;
	private int[] visited;

	public static void main(String[] args) {
		Possible_Bipartition solution = new Possible_Bipartition();
		int N = 4;
		int[][] dislikes = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		boolean result = solution.possibleBipartition(N, dislikes);
		System.out.println(result); // true
		result = solution.possibleBipartitionUsingBFS(N, dislikes);
		System.out.println(result); //false

		N = 3;
		dislikes = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		result = solution.possibleBipartition(N, dislikes);
		System.out.println(result); //false
		result = solution.possibleBipartitionUsingBFS(N, dislikes);
		System.out.println(result); //false

		N = 5;
		dislikes = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };
		result = solution.possibleBipartition(N, dislikes);
		System.out.println(result); //false
		result = solution.possibleBipartitionUsingBFS(N, dislikes);
		System.out.println(result); //false
	}

	private Map<Integer, List<Integer>> buildGraph(int[][] dislikes) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < dislikes.length; i++) {
			List<Integer> neighbours = graph.containsKey(dislikes[i][0]) ? graph.get(dislikes[i][0]) : new ArrayList<>();
			neighbours.add(dislikes[i][1]);
			graph.put(dislikes[i][0], neighbours);
			neighbours = graph.containsKey(dislikes[i][1]) ? graph.get(dislikes[i][1]) : new ArrayList<>();
			neighbours.add(dislikes[i][0]);
			graph.put(dislikes[i][1], neighbours);
		}
		return graph;
	}

	public boolean possibleBipartition(int N, int[][] dislikes) {
		if (N == 0 || dislikes == null || dislikes.length == 0) {
			return true;
		}
		this.graph = buildGraph(dislikes);
		this.visited = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0) { // not visited color i.e Gray
				if (!dfs(i, 1)) { // visit with Red Color
					return false;
				}
			}
		}
		return true;
	}

	private boolean dfs(int node, int color) {
		// Visited and mismatch is color means not bipartite
		if (visited[node] != 0 && visited[node] != color)
			return false;

		if (visited[node] == color)
			return true;

		// Visit not with red color and neighbours with blue color
		visited[node] = color;
		List<Integer> neighbours = graph.get(node);
		if (neighbours == null)
			return true;
		for (Integer neighbour : neighbours) {
			if (!dfs(neighbour, -color)) //visit neighbors with Blue Color
				return false;
		}
		return true;
	}

	public boolean possibleBipartitionUsingBFS(int N, int[][] dislikes) {
		if (N == 0 || dislikes == null || dislikes.length == 0) {
			return true;
		}
		this.graph = buildGraph(dislikes);
		this.visited = new int[N + 1];
		Deque<Integer> queue = new ArrayDeque<>(N);

		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0) { // not visited color i.e Gray
				visited[i] = 1;
				queue.offer(i);
				while (!queue.isEmpty()) {
					int node = queue.poll();
					List<Integer> neighbors = graph.get(node);
					if (neighbors == null) {
						continue;
					}
					for (Integer neighbour : neighbors) {
						// node and neighbour color matched i.e cannot bipartite
						if (visited[neighbour] == visited[node]) {
							return false;
						}
						// Not Visited before
						if (visited[neighbour] == 0) {
							visited[neighbour] = -visited[node]; // mark neighbours with opposite color
							queue.offer(neighbour);
						}
					}
				}
			}
		}
		return true;
	}

}
