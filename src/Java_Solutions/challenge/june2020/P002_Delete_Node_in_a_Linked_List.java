/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.HashMap;
import java.util.Map;

public class P002_Delete_Node_in_a_Linked_List {
	public static void main(String[] args) {
		P002_Delete_Node_in_a_Linked_List solution = new P002_Delete_Node_in_a_Linked_List();
		int[] inputs = new int[] { 4, 5, 1, 9 };
		ListNode head = solution.buildList(inputs);
		solution.printList(head);
		Map<Integer, ListNode> map = new HashMap<>();
		ListNode current = head;
		while (current != null) {
			map.put(current.val, current);
			current = current.next;
		}
		solution.deleteNode(map.get(5));
		solution.printList(head);
	}

	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		// check if node is last node
		if (node.next == null) {
			node = null;
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}

	private ListNode buildList(int[] values) {
		if (values == null || values.length == 0) {
			return null;
		}
		ListNode head = new ListNode(values[0]);
		ListNode current = head;
		for (int i = 1; i < values.length; i++) {
			ListNode node = new ListNode(values[i]);
			current.next = node;
			current = current.next;
		}
		return head;
	}

	private void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.printf(" %d -> ", current.val);
			current = current.next;
		}
		System.out.println("null");
	}

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
