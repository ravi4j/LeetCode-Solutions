/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P015_Pow {
	public static void main(String[] args) {
		P015_Pow solution = new P015_Pow();
		double x = 2.0;
		int n = 10;
		double result = solution.myPow(x, n);
		System.out.println(result);

		x = 2.10;
		n = 3;
		result = solution.myPow(x, n);
		System.out.println(result);

		x = 2.0;
		n = -2;
		result = solution.myPow(x, n);
		System.out.println(result);

		x = 34.00515;
		n = -3;
		result = solution.myPow(x, n);
		System.out.println(result);

	}

	public double myPow(double x, int n) {
		if (n == 0) {
			return 1.0;
		}
		double result = myPow(x, n / 2);
		if (n % 2 == 0) {
			return result * result;
		} else if (n > 0) {
			return result * result * x;
		} else {
			return result * result / x;
		}
	}
}
