/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class Bitwise_AND_of_Numbers_Range {
	public static void main(String[] args) {
		Bitwise_AND_of_Numbers_Range solution = new Bitwise_AND_of_Numbers_Range();
		int m = 5;
		int n = 7;
		int result = solution.rangeBitwiseAnd(m, n);
		System.out.println(result);
		m = 0;
		n = 1;
		result = solution.rangeBitwiseAnd(m, n);
		System.out.println(result);

	}

	public int rangeBitwiseAnd(int m, int n) {
		while (n > m) {
			n = n & n - 1;
		}
		return m & n;
	}
}
