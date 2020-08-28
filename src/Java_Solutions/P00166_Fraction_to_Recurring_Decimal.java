/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.HashMap;
import java.util.Map;

public class P00166_Fraction_to_Recurring_Decimal {
	public static void main(String[] args) {
		P00166_Fraction_to_Recurring_Decimal solution = new P00166_Fraction_to_Recurring_Decimal();
		int numerator = 1;
		int denominator = 2;
		String result = solution.fractionToDecimal(numerator, denominator);
		System.out.println(result); // 0.5

		numerator = 2;
		denominator = 1;
		result = solution.fractionToDecimal(numerator, denominator);
		System.out.println(result); // 2

		numerator = 2;
		denominator = 3;
		result = solution.fractionToDecimal(numerator, denominator);
		System.out.println(result); // 0.(6)\

		numerator = -1;
		denominator = -2147483648;
		result = solution.fractionToDecimal(numerator, denominator);
		System.out.println(result); // "0.0000000004656612873077392578125"
	}

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}

		if (denominator == 0) {
			return "";
		}

		String result = "";
		if ((numerator < 0) ^ (denominator < 0)) {
			result += "-";
		}

		long N = Math.abs((long) numerator);
		long D = Math.abs((long) denominator);

		long quotient = N / D;
		result += String.valueOf(quotient);
		long R = (N % D) * 10;
		if (R == 0) {
			return result;
		}

		Map<Long, Integer> remMap = new HashMap<>();
		result += ".";
		while (R != 0) {
			if (remMap.containsKey(R)) {
				int resultLen = remMap.get(R);
				String P1 = result.substring(0, resultLen);
				String P2 = result.substring(resultLen);
				result = P1 + "(" + P2 + ")";
				return result;
			}
			remMap.put(R, result.length());
			quotient = R / D;
			result += String.valueOf(quotient);
			R = (R % D) * 10;
		}
		return result;
	}
}
