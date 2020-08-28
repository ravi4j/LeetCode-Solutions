/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.august2020;

import java.util.Arrays;

public class P015_Non_overlapping_Intervals_Solution {
	public static void main(String[] args) {
		P015_Non_overlapping_Intervals_Solution solution = new P015_Non_overlapping_Intervals_Solution();
		int[][] intervals = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int result = solution.eraseOverlapIntervals(intervals);
		System.out.println(result); // 1

		intervals = new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		result = solution.eraseOverlapIntervals(intervals);
		System.out.println(result); //2

		intervals = new int[][] { { 1, 2 }, { 2, 3 }, };
		result = solution.eraseOverlapIntervals(intervals);
		System.out.println(result); //0
	}

	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		// sort by finish time
		Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
		int minErase = 0;
		int lastEnd = Integer.MIN_VALUE;
		for (int i = 0; i < intervals.length; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];
			if (start < lastEnd) {
				minErase += 1;
			} else {
				lastEnd = end;
			}
		}
		return minErase;
	}
}
