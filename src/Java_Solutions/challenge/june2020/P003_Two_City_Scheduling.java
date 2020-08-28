/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.Arrays;

public class P003_Two_City_Scheduling {
	public static void main(String[] args) {
		P003_Two_City_Scheduling solution = new P003_Two_City_Scheduling();
		int[][] costs = new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		int minCost = solution.twoCitySchedCost(costs);
		System.out.println(minCost); //110

		costs = new int[][] { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
		minCost = solution.twoCitySchedCost(costs);
		System.out.println(minCost); //1859
	}

	public int twoCitySchedCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int n = costs.length;
		Arrays.sort(costs, (a, b) -> (a[0] - b[0]) - (a[1] - b[1]));
		int minCost = 0;
		for (int i = 0; i < n / 2; i++) {
			minCost += costs[i][0];
		}
		for (int i = n / 2; i < n; i++) {
			minCost += costs[i][1];
		}
		return minCost;
	}
}
