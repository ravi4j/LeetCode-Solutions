/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.ArrayDeque;
import java.util.Deque;

public class Online_Stock_Span {

	public static void main(String[] args) {
		StockSpanner S = new StockSpanner();
		System.out.println(S.next(100)); //is called and returns 1,
		System.out.println(S.next(80));//is called and returns 1,
		System.out.println(S.next(60));// is called and returns 1,
		System.out.println(S.next(70));//is called and returns 2,
		System.out.println(S.next(60));//is called and returns 1,
		System.out.println(S.next(75));//is called and returns 4,
		System.out.println(S.next(85));//is called and returns 6.

	}

	private static class StockSpanner {
		private Deque<int[]> stack;

		public StockSpanner() {
			stack = new ArrayDeque<>();
		}

		public int next(int price) {
			int span = 1;
			while (!stack.isEmpty() && price >= stack.peek()[0]) {
				span += stack.pop()[1];
			}
			stack.push(new int[] { price, span });
			return span;
		}
	}
}
