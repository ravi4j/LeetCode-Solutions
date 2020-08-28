/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P020_Remove_Linked_List_Elements {
	public static void main(String[] args) {
		P020_Remove_Linked_List_Elements solution = new P020_Remove_Linked_List_Elements();
		int[] elements = new int[] { 1, 2, 6, 3, 4, 5, 6 };
		int val = 6;
		ListNode head = solution.buildList(elements);
		head = solution.removeElements(head, val);
		solution.printList(head);
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode current = dummy;
		while (current.next != null) {
			if (current.next.val == val) {
				ListNode next = current.next;
				current.next = next.next;
			} else {
				current = current.next;
			}
		}
		return dummy.next;
	}

	private ListNode buildList(int[] elements) {

		ListNode head = new ListNode(elements[0]);
		ListNode current = head;
		for (int i = 1; i < elements.length; i++) {
			ListNode node = new ListNode(elements[i]);
			current.next = node;
			current = node;
		}
		return head;
	}

	private void printList(ListNode head) {
		if (head == null) {
			return;
		}
		for (ListNode node = head; node != null; node = node.next) {
			System.out.printf("%d -> ", node.val);
		}
		System.out.println("null");
	}

	private class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
