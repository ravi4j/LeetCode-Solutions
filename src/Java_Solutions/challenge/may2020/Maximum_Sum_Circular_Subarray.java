/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.Arrays;

public class Maximum_Sum_Circular_Subarray {
	public static void main(String[] args) {
		Maximum_Sum_Circular_Subarray solution = new Maximum_Sum_Circular_Subarray();
		int[] A = new int[] { 1, -2, 3, -2 };
		int result = solution.maxSubarraySumCircular(A);
		System.out.println(result); // 3

		A = new int[] { 5, -3, 5 };
		result = solution.maxSubarraySumCircular(A);
		System.out.println(result); // 10

		A = new int[] { 3, -1, 2, -1 };
		result = solution.maxSubarraySumCircular(A);
		System.out.println(result); // 4

		A = new int[] { 3, -2, 2, -3 };
		result = solution.maxSubarraySumCircular(A);
		System.out.println(result); // 3

		A = new int[] { -2, -3, -1 };
		result = solution.maxSubarraySumCircular(A);
		System.out.println(result); // -1

	}

	public int maxSubarraySumCircular(int[] A) {

		int min = Integer.MIN_VALUE;
		boolean positive = false;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				positive = true;
				break;
			} else {
				if (A[i] > min) {
					min = A[i];
				}
			}
		}
		if (!positive) {
			return min;
		}

		// Negate A
		for (int i = 0; i < A.length; i++) {
			A[i] = -A[i];
		}

		int negMaxSum = kadane(A);

		// Restore A
		for (int i = 0; i < A.length; i++) {
			A[i] = -A[i];
		}

		int maxSum = kadane(A);

		int sumA = Arrays.stream(A).sum();

		return Math.max(maxSum, sumA + negMaxSum);

	}

	private int kadane(int[] A) {
		int maxEndHere = 0;
		int maxSoFar = 0;
		for (int i = 0; i < A.length; i++) {
			maxEndHere = maxEndHere + A[i];
			if (maxEndHere < 0) {
				maxEndHere = 0;
			}
			if (maxSoFar < maxEndHere) {
				maxSoFar = maxEndHere;
			}
		}
		return maxSoFar;
	}
}
