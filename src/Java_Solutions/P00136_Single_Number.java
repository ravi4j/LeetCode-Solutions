/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00136_Single_Number {
	public static void main(String[] args) {
		int[] input = {2,2,1};
		P00136_Single_Number solution = new P00136_Single_Number();
		int unique = solution.singleNumber(input);
		System.out.println(unique);
		int[] input2 = {4,1,2,1,2};
		unique = solution.singleNumber(input2);
		System.out.println(unique);
	}

	public int singleNumber(int[] nums) {
		int x = 0;
		for (int a : nums) {
			x = x ^ a;
		}
		return x;
	}

}
