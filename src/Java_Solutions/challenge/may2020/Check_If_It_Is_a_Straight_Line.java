/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class Check_If_It_Is_a_Straight_Line {
	public static void main(String[] args) {
		Check_If_It_Is_a_Straight_Line solution = new Check_If_It_Is_a_Straight_Line();
		int[][] coordinates = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
		boolean result = solution.checkStraightLine(coordinates);
		System.out.println(result);

		coordinates = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
		result = solution.checkStraightLine(coordinates);
		System.out.println(result);

	}

	public boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 2) {
			return true;
		}
		Point[] points = new Point[coordinates.length];
		for (int i = 0; i < coordinates.length; i++) {
			points[i] = new Point(coordinates[i][0], coordinates[i][1]);
		}
		Point p0 = points[0];
		Point p1 = points[1];

		for (int i = 2; i < points.length; i++) {
			Point pi = points[i];
			if (((p1.y - p0.y) * (pi.x - p1.x)) != ((pi.y - p1.y) * (p1.x - p0.x))){
				return false;
			}

		} return true;
	}

	private class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
