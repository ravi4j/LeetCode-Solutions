package leetcode;/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00148_Sort_List {

	public static void main(String[] args) {
		P00148_Sort_List solution = new P00148_Sort_List();
		int[] input = { 4, 2, 1, 3 };
		ListNode head = solution.buildList(input);
		solution.printList(head);
		ListNode sorted = solution.sortList(head);
		solution.printList(sorted);
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode mid = partition(p1);
		ListNode p2 = mid.next;
		mid.next = null;
		p1 = sortList(p1);
		p2 = sortList(p2);
		return merge(p1, p2);
	}

	private ListNode partition(ListNode list) {
		ListNode slow = list;
		ListNode fast = list;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode merge(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		ListNode p1 = list1;
		ListNode p2 = list2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}
		return head.next;
	}

	private ListNode buildList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		ListNode root = new ListNode(arr[0]);
		ListNode current = root;
		for (int i = 1; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			current.next = node;
			current = node;
		}
		return root;
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

		ListNode(int x) {
			val = x;
		}
	}

}
