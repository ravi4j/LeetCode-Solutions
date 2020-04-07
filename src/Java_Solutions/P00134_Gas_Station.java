/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00134_Gas_Station {
	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		P00134_Gas_Station solution = new P00134_Gas_Station();
		int result = solution.canCompleteCircuit(gas, cost);
		System.out.println(result);
		gas = new int[] { 2, 3, 4 };
		cost = new int[] { 3, 4, 3 };
		result = solution.canCompleteCircuit(gas, cost);
		System.out.println(result);
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sumRemainingAtStart = 0;
		int totalFuelNeeded = 0;
		int startAt = 0;
		for (int i = 0; i < gas.length; i++) {
			int remaining = gas[i] - cost[i];
			if (sumRemainingAtStart >= 0) {
				sumRemainingAtStart += remaining;
			} else {
				startAt = i;
				sumRemainingAtStart = remaining;
			}
			totalFuelNeeded += remaining;
		}
		return totalFuelNeeded >= 0 ? startAt : -1;
	}

}
