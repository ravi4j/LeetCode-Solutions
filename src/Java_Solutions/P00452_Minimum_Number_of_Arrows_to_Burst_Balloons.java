/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.Arrays;

public class P00452_Minimum_Number_of_Arrows_to_Burst_Balloons {
	public static void main(String[] args) {
		int[][] inputs = new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		P00452_Minimum_Number_of_Arrows_to_Burst_Balloons solution = new P00452_Minimum_Number_of_Arrows_to_Burst_Balloons();
		int min = solution.findMinArrowShots(inputs);
		System.out.println(min);
	}

	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);

		int px = points[0][0];
		int py = points[0][1];
		int min = 0;
		for (int i = 0; i < points.length; i++) {
			int cx = points[i][0];
			int cy = points[i][1];

			if (cx <= py) {
				// merge
				px = Math.max(px, cx);
				py = Math.min(py, cy);

			} else {
				min++;
				px = cx;
				py = cy;
			}
		}
		return min + 1;
	}
}
