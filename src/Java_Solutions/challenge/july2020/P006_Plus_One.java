/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.Arrays;

public class P006_Plus_One {
	public static void main(String[] args) {
		P006_Plus_One solution = new P006_Plus_One();
		int[] digits = new int[] { 1, 2, 3 };
		int[] result = solution.plusOne(digits);
		System.out.println(Arrays.toString(result)); // [1, 2, 4]

		digits = new int[] { 4, 3, 2, 1 };
		result = solution.plusOne(digits);
		System.out.println(Arrays.toString(result)); // [ 4 , 3, 2 , 2]

		digits = new int[] { 9 };
		result = solution.plusOne(digits);
		System.out.println(Arrays.toString(result)); // [ 4 , 3, 2 , 2]
	}

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[0];
		}
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carry;
			carry = sum >= 10 ? 1 : 0;
			digits[i] = sum % 10;
		}
		if (carry == 1) {
			int[] result = new int[digits.length + 1];
			System.arraycopy(digits, 0, result, 1, digits.length);
			result[0] = 1;
			return result;
		} else {
			return digits;
		}
	}
}
