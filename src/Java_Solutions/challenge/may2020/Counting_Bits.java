/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.Arrays;

public class Counting_Bits {
	public static void main(String[] args) {
		Counting_Bits solution = new Counting_Bits();
		int num = 2;
		int[] result = solution.countBits(num);
		System.out.println(Arrays.toString(result));

		num = 5;
		result = solution.countBits(num);
		System.out.println(Arrays.toString(result));
	}

	public int[] countBits(int num) {
		if (num == 0) {
			return new int[] { 0 };
		}
		int[] result = new int[num + 1];
		int powerOfTwo = 1;
		int index = 1;
		for (int i = 1; i <= num; i++) {
			if (i == powerOfTwo) {
				result[i] = 1;
				powerOfTwo <<= 1;
				index = 1;
			} else {
				result[i] = result[index] + 1;
				index++;
			}
		}
		return result;
	}

}
