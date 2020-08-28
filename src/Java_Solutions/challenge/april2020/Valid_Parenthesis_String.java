/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.ArrayDeque;
import java.util.Deque;

public class Valid_Parenthesis_String {
	public static void main(String[] args) {
		Valid_Parenthesis_String solution = new Valid_Parenthesis_String();
		String s = "()";
		boolean result = solution.checkValidString(s);
		System.out.println(result);

		s = "(*)";
		result = solution.checkValidString(s);
		System.out.println(result);

		s = "(*))";
		result = solution.checkValidString(s);
		System.out.println(result);

		s = "(*)))";
		result = solution.checkValidString(s);
		System.out.println(result);

		System.out.println("With Stack");

		s = "()";
		result = solution.checkValidStringWithStack(s);
		System.out.println(result);

		s = "(*)";
		result = solution.checkValidStringWithStack(s);
		System.out.println(result);

		s = "(*))";
		result = solution.checkValidStringWithStack(s);
		System.out.println(result);

		s = "(*)))";
		result = solution.checkValidStringWithStack(s);
		System.out.println(result);

	}

	public boolean checkValidString(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.length() == 1 && s.charAt(0) == '*') {
			return true;
		}
		if (s.length() == 1 && s.charAt(0) != '*') {
			return false;
		}

		int leftBalance = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				leftBalance--;
			} else {
				leftBalance++;
			}
			if (leftBalance < 0) {
				return false;
			}
		}

		if (leftBalance == 0) {
			return true;
		}
		int rightBalance = 0;
		for (int j = s.length() - 1; j >= 0; j--) {
			if (s.charAt(j) == '(') {
				rightBalance--;
			} else {
				rightBalance++;
			}
			if (rightBalance < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean checkValidStringWithStack(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.length() == 1 && s.charAt(0) == '*') {
			return true;
		}
		if (s.length() == 1 && s.charAt(0) != '*') {
			return false;
		}

		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> stackStar = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else if (ch == '*') {
				stackStar.push(i);
			} else if (ch == ')') {
				if (stack.size() > 0) {
					stack.pop();
				} else if (stackStar.size() > 0) {
					stackStar.pop();
				} else {
					return false;
				}
			}
		}
		while (!stack.isEmpty() && !stackStar.isEmpty()) {
			if (stack.peek() < stackStar.peek()) {
				stack.pop();
				stackStar.pop();
			} else {
				break;
			}
		}
		return stack.isEmpty();
	}

}
