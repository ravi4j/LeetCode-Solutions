/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static void main(String[] args) {
		int n = 1474573736;
		HappyNumber happyNumber =  new HappyNumber();
		boolean isHappy  = happyNumber.isHappy(n);
		System.out.println(isHappy);
		int n1 = 19;
		boolean isHappy1  = happyNumber.isHappy(n1);
		System.out.println(isHappy1);
	}

	public boolean isHappy(int n) {
		Set<Long> set = new HashSet<>();
		long num = n;
		while (num != 1) {
			num = sum(num);
			if(set.contains(num)){
				return false;
			}
			set.add(num);
		}
		return true;
	}

	private long sum(long n) {
		long sum = 0;
		long base = 1;
		while (n % base < n) {
			long digit = (n / base) % 10;
			sum += digit * digit;
			base *= 10;
		}
		return sum;
	}

}
