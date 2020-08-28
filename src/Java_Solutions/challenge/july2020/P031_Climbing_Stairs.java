/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.HashMap;
import java.util.Map;

public class P031_Climbing_Stairs {
	private Map<Integer, Integer> mem = new HashMap<>();

	public static void main(String[] args) {
		P031_Climbing_Stairs solution = new P031_Climbing_Stairs();
		int n = 2;
		int result = solution.climbStairs(n);
		System.out.println(result);

		n = 3;
		result = solution.climbStairs(n);
		System.out.println(result);

		n = 4;
		result = solution.climbStairs(n);
		System.out.println(result);

		n = 5;
		result = solution.climbStairs(n);
		System.out.println(result);
	}

	public int climbStairs(int n) {
		return climbStairsHelper(n);

	}

	private int climbStairsHelper(int n) {
		int result = 0;
		if (mem.containsKey(n)) {
			return mem.get(n);
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}
		result = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
		mem.put(n, result);
		return result;
	}
}
