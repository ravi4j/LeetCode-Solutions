/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.ArrayDeque;
import java.util.Deque;

public class P010_Flatten_a_Multilevel_Doubly_Linked_List {
	public static void main(String[] args) {
		P010_Flatten_a_Multilevel_Doubly_Linked_List solution = new P010_Flatten_a_Multilevel_Doubly_Linked_List();
		Node head = solution.buildList();
		Node result = solution.flatten(head);
		solution.printList(result);
	}

	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		Node dummy = new Node(-1);
		dummy.next = head;
		Node prev = dummy;
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			prev.next = current;
			current.prev = prev;
			if (current.next != null) {
				stack.push(current.next);
			}
			if (current.child != null) {
				stack.push(current.child);
				current.child = null;
			}
			prev = current;
		}
		dummy.next.prev = null;
		return dummy.next;
	}

	private void printList(Node node) {
		Node current = node;
		System.out.print("[ ");
		while (current != null) {
			System.out.printf(" %d ", current.val);
			if (current.next != null) {
				System.out.print(", ");
			}
			current = current.next;
		}
		System.out.println("]");
	}

	private Node buildList() {
		Node head = new Node(1);
		Node current = head;
		for (int i = 2; i <= 6; i++) {
			Node node = new Node(i);
			current.next = node;
			node.prev = current;
			current = node;
		}
		Node head2 = new Node(7);
		current = head2;
		for (int i = 8; i <= 10; i++) {
			Node node = new Node(i);
			current.next = node;
			node.prev = current;
			current = node;
		}

		Node head3 = new Node(11);
		current = head3;
		for (int i = 12; i <= 12; i++) {
			Node node = new Node(i);
			current.next = node;
			node.prev = current;
			current = node;
		}

		head.next.next.child = head2;
		head2.next.child = head3;
		return head;
	}

	private class Node {
		public int val;

		Node(int val) {
			this.val = val;
		}

		public Node prev;
		public Node next;
		public Node child;
	}

	;
}
