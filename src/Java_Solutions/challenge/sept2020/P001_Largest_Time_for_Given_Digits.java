/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

import java.util.ArrayList;
import java.util.List;

public class P001_Largest_Time_for_Given_Digits {
	public static void main(String[] args) {
		P001_Largest_Time_for_Given_Digits solution = new P001_Largest_Time_for_Given_Digits();
		int[] A = new int[] { 1, 2, 3, 4 };
		String result = solution.largestTimeFromDigits(A);
		System.out.println(result);// 23:41

		A = new int[] { 5, 5, 5, 5 };
		result = solution.largestTimeFromDigits(A);
		System.out.println(result);// ""

		A = new int[] { 0, 0, 0, 0 };
		result = solution.largestTimeFromDigits(A);
		System.out.println(result);// "00:00"

	}

	public String largestTimeFromDigits(int[] A) {
		List<List<Integer>> permutations = new ArrayList<>();
		boolean[] visited = new boolean[A.length];
		dfs(A, permutations, visited, new ArrayList<>());
		int maxHour = -1;
		int maxMin = -1;
		for (List<Integer> permutation : permutations) {
			int hour = getHours(permutation);
			int minutes = getMinutes(permutation);
			if ((hour > maxHour && minutes != -1) || (hour == maxHour && minutes > maxMin)) {
				maxHour = hour;
				maxMin = minutes;
			}
		}
		return (maxHour != -1 && maxMin != -1) ? String.format("%02d:%02d", maxHour, maxMin) : "";
	}

	private void dfs(int[] A, List<List<Integer>> permutations, boolean[] visited, List<Integer> result) {
		if (A.length == result.size()) {
			permutations.add(new ArrayList<>(result));
			return;
		}
		for (int i = 0; i < A.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			result.add(A[i]);
			dfs(A, permutations, visited, result);
			result.remove(result.size() - 1);
			visited[i] = false;
		}
	}

	private int getHours(List<Integer> time) {
		int hour = time.get(0) * 10 + time.get(1);
		if (hour >= 0 && hour <= 23) {
			return hour;
		}
		return -1;
	}

	private int getMinutes(List<Integer> time) {
		int minutes = time.get(2) * 10 + time.get(3);
		if (minutes >= 0 && minutes <= 59) {
			return minutes;
		}
		return -1;
	}

}
