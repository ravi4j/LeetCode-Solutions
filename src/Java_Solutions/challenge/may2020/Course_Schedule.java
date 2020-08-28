/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course_Schedule {
	private Map<Integer, List<Integer>> graph;

	public static void main(String[] args) {
		Course_Schedule solution = new Course_Schedule();
		int numCourses = 2;
		int[][] prerequisites = new int[][] { { 1, 0 } };
		boolean result = solution.canFinish(numCourses, prerequisites);
		System.out.println(result); // true

		numCourses = 2;
		prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
		result = solution.canFinish(numCourses, prerequisites);
		System.out.println(result); // false
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (numCourses == 0 || prerequisites.length == 0) {
			return true;
		}

		// 1. build graph
		buildGraph(prerequisites);
		int[] visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (hasCycle(visited, i)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasCycle(int[] visited, int node) {
		// Node Visited before has cycle
		if (visited[node] == -1) {
			return true;
		}
		// Node not part of cycle.
		if (visited[node] == 1) {
			return false;
		}

		visited[node] = -1;
		List<Integer> adj = graph.get(node);
		if (adj != null) {
			for (Integer next : adj) {
				if (hasCycle(visited, next)) {
					return false;
				}
			}
		}
		// This node is not a part of cycle.
		visited[node] = 1;
		return false;
	}

	private void buildGraph(int[][] prerequisites) {
		this.graph = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			List<Integer> neighbours = graph.containsKey(prerequisites[i][0]) ? graph.get(prerequisites[i][0]) : new ArrayList<>();
			neighbours.add(prerequisites[i][1]);
			graph.put(prerequisites[i][0], neighbours);
		}
	}
}
