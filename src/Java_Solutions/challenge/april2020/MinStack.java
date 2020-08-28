/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class MinStack {
	EntryNode top;

	public MinStack() {

	}

	public void push(int x) {
		if (top == null) {
			top = new EntryNode(x, x);
		} else {
			EntryNode entry = new EntryNode(x, Math.min(x, top.min));
			entry.next = top;
			top = entry;
		}
	}

	public void pop() {
		if (top == null) {
			return;
		}
		EntryNode temp = top.next;
		top.next = null;
		top = temp;
	}

	public int top() {
		if (top == null) {
			return -1;
		}
		return top.val;
	}

	public int getMin() {
		if (top == null) {
			return -1;
		}
		return top.min;
	}

	private class EntryNode {
		int val;
		int min;
		EntryNode next;

		public EntryNode(int val, int min) {
			this.min = min;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		System.out.println(minStack.getMin()); //  --> Returns -3.
		minStack.pop();
		System.out.println(minStack.getMin()); //  --> Returns -3.
		minStack.pop();
		System.out.println(minStack.getMin()); //  --> Returns -3.
		minStack.pop();
		System.out.println(minStack.getMin()); //  --> Returns -2.
	}

}


