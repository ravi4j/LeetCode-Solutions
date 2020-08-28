/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.ArrayList;
import java.util.List;

public class P024_All_Paths_From_Source_to_Target {
	public static void main(String[] args) {
		P024_All_Paths_From_Source_to_Target solution = new P024_All_Paths_From_Source_to_Target();
		int[][] graph = new int[][] { { 1, 2 }, { 3 }, { 3 }, {} };
		List<List<Integer>> result = solution.allPathsSourceTarget(graph);
		System.out.println(result); // [[0, 1, 3], [0, 2, 3]]
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		if (graph == null || graph.length == 0) {
			return result;
		}
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfs(graph, 0, path, result);
		return result;
	}

	private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {

		if (node == graph.length - 1) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int adj : graph[node]) {
			path.add(adj);
			dfs(graph, adj, path, result);
			path.remove(path.size() - 1);
		}
	}

}
