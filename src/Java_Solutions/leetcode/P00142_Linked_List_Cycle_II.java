package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00142_Linked_List_Cycle_II {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = head;
		P00142_Linked_List_Cycle_II solution = new P00142_Linked_List_Cycle_II();
		ListNode node = solution.detectCycle(head);
		System.out.println(node.val);

		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(0);
		head1.next.next.next =  new ListNode(4);
		head1.next.next.next.next = head1.next;
		ListNode node1 = solution.detectCycle(head1);
		System.out.println(node1.val);

		ListNode head2 = new ListNode(1);
		ListNode node2 = solution.detectCycle(head2);
		System.out.println(node2.val);
	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		// Check if it has cycle
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
