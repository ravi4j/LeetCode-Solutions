/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P005_Random_Pick_with_Weight {
	private int[] weightCumulativeSum;
	private int totalWeightSum;

	public static void main(String[] args) {
		int[] weights = new int[] { 1 };
		P005_Random_Pick_with_Weight solution = new P005_Random_Pick_with_Weight(weights);
		System.out.println(solution.pickIndex());

		weights = new int[] { 1, 3 };
		solution = new P005_Random_Pick_with_Weight(weights);
		System.out.printf("%d ", solution.pickIndex());
		System.out.printf("%d ", solution.pickIndex());
		System.out.printf("%d ", solution.pickIndex());
		System.out.printf("%d ", solution.pickIndex());
		System.out.println(solution.pickIndex());

		weights = new int[] { 1, 3, 4, 5, 2 };
		solution = new P005_Random_Pick_with_Weight(weights);
		System.out.printf("%d ", solution.pickIndex());
		System.out.printf("%d ", solution.pickIndex());
		System.out.printf("%d ", solution.pickIndex());
		System.out.printf("%d ", solution.pickIndex());
		System.out.println(solution.pickIndex());
	}

	public P005_Random_Pick_with_Weight(int[] w) {
		this.weightCumulativeSum = new int[w.length];
		for (int i = 0; i < w.length; i++) {
			this.totalWeightSum += w[i];
			this.weightCumulativeSum[i] = this.totalWeightSum;
		}
	}

	public int pickIndex() {
		int idx = (int) (Math.random() * this.totalWeightSum);
		return binarySearch(idx + 1);
	}

	private int binarySearch(int target) {
		int low = 0;
		int high = this.weightCumulativeSum.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (this.weightCumulativeSum[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}
