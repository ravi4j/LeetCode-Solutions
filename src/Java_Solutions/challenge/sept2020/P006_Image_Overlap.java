/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P006_Image_Overlap {
	public static void main(String[] args) {
		P006_Image_Overlap solution = new P006_Image_Overlap();
		int[][] A = new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		int[][] B = new int[][] { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
		int result = solution.largestOverlap(A, B);
		System.out.println(result);
	}

	public int largestOverlap(int[][] A, int[][] B) {
		List<int[]> lA = new ArrayList<>();
		List<int[]> lB = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 1) {
					lA.add(new int[] { i, j });
				}
				if (B[i][j] == 1) {
					lB.add(new int[] { i, j });
				}
			}
		}
		//lA.stream().forEach(array -> System.out.print(Arrays.toString(array) + " "));
		//System.out.println();
		//lB.stream().forEach(array -> System.out.print(Arrays.toString(array) + " "));
		//System.out.println();
		Map<String, Integer> countMap = new HashMap<>();
		for (int[] a : lA) {
			for (int[] b : lB) {
				String key = "[" + (a[0] - b[0]) + "," + (a[1] - b[1]) + "]";
				countMap.merge(key, 1, Integer::sum);
			}
		}
		//System.out.println(countMap);
		int max = 0;
		for (int value : countMap.values()) {
			max = Math.max(max, value);
		}
		return max;
	}
}
