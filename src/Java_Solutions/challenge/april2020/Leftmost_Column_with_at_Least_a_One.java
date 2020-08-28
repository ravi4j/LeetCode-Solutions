/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.Arrays;
import java.util.List;

public class Leftmost_Column_with_at_Least_a_One {
	public static void main(String[] args) {
		Leftmost_Column_with_at_Least_a_One solution = new Leftmost_Column_with_at_Least_a_One();
		int[][] matrix = new int[][] { { 0, 0 }, { 1, 1 } };
		BinaryMatrix binaryMatrix = solution.getBinaryMatrix(matrix);
		int result = solution.leftMostColumnWithOne(binaryMatrix);
		System.out.println(result);

		matrix = new int[][] { { 0, 0 }, { 0, 0 } };
		binaryMatrix = solution.getBinaryMatrix(matrix);
		result = solution.leftMostColumnWithOne(binaryMatrix);
		System.out.println(result);

		matrix = new int[][] { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 1 } };
		binaryMatrix = solution.getBinaryMatrix(matrix);
		result = solution.leftMostColumnWithOne(binaryMatrix);
		System.out.println(result);

	}

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		if (binaryMatrix == null) {
			return -1;
		}
		List<Integer> dimensions = binaryMatrix.dimensions();
		int rows = dimensions.get(0);
		int columns = dimensions.get(1);
		int atRow = 0;
		int atColumn = columns - 1;
		while (atRow < rows && atColumn >= 0) {
			if (binaryMatrix.get(atRow, atColumn) == 1) {
				atColumn = atColumn - 1;
			} else {
				atRow = atRow + 1;
			}
		}

		if (atColumn != columns - 1) {
			return atColumn + 1;
		} else {
			return -1;
		}
	}

	private BinaryMatrix getBinaryMatrix(int[][] matrix) {
		return new BinaryMatrixImpl(matrix);
	}

	private class BinaryMatrixImpl implements BinaryMatrix {
		private int[][] matrix;

		public BinaryMatrixImpl(int[][] matrix) {
			this.matrix = matrix;
		}

		@Override
		public int get(int x, int y) {
			return matrix[x][y];
		}

		@Override
		public List<Integer> dimensions() {
			if (matrix == null || matrix.length == 0) {
				Arrays.asList(0, 0);
			}
			return Arrays.asList(matrix.length, matrix[0].length);
		}
	}

	private interface BinaryMatrix {
		public int get(int x, int y);

		public List<Integer> dimensions();
	}
}
