/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.ArrayDeque;
import java.util.Deque;

public class PerformStringShifts {
	public static void main(String[] args) {
		PerformStringShifts solution = new PerformStringShifts();
		String s = "abc";
		int[][] shift = new int[][] { { 0, 1 }, { 1, 2 } };
		String result = solution.stringShiftOptimized(s, shift);
		System.out.println(result);

		s = "abcdefg";
		shift = new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } };
		result = solution.stringShiftOptimized(s, shift);
		System.out.println(result);

	}

	public String stringShift(String s, int[][] shift) {
		if (s == null || s.length() == 1 || shift == null || shift.length == 0) {
			return s;
		}
		Deque<Character> queue = new ArrayDeque<>();
		for (Character ch : s.toCharArray()) {
			queue.add(ch);
		}
		for (int i = 0; i < shift.length; i++) {
			if (shift[i][0] == 0) {
				for (int j = 0; j < shift[i][1]; j++) {
					queue.addLast(queue.removeFirst());
				}
			} else {
				for (int j = 0; j < shift[i][1]; j++) {
					queue.addFirst(queue.removeLast());
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for (Character ch : queue) {
			builder.append(ch);
		}
		return builder.toString();
	}

	public String stringShiftOptimized(String s, int[][] shift) {
		if (s == null || s.length() == 1 || shift == null || shift.length == 0) {
			return s;
		}
		Deque<Character> queue = new ArrayDeque<>();
		for (Character ch : s.toCharArray()) {
			queue.add(ch);
		}
		int leftShifts = 0, rightShifts = 0;
		for (int i = 0; i < shift.length; i++) {
			if (shift[i][0] == 0) {
				leftShifts += shift[i][1];
			} else {
				rightShifts += shift[i][1];
			}
		}
		int netShift = leftShifts - rightShifts;
		int absNetShift = Math.abs(netShift);
		if (netShift > 0) { // left shift once
			for (int j = 0; j < absNetShift; j++) {
				queue.addLast(queue.removeFirst());
			}
		} else { // right shift once
			for (int j = 0; j < absNetShift; j++) {
				queue.addFirst(queue.removeLast());
			}
		}
		StringBuilder builder = new StringBuilder();
		for (Character ch : queue) {
			builder.append(ch);
		}
		return builder.toString();
	}

}
