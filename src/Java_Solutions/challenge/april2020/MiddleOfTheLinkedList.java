/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class MiddleOfTheLinkedList {
	public static void main(String[] args) {
		MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();
		int[] input = { 1, 2, 3, 4, 5 };
		ListNode head = solution.buildList(input);
		solution.printList(head);
		ListNode mid = solution.middleNode(head);
		System.out.println("Mid : " + mid.val);
		int[] input1 = { 1, 2, 3, 4, 5, 6 };
		head = solution.buildList(input1);
		solution.printList(head);
		mid = solution.middleNode(head);
		System.out.println("Mid : " + mid.val);
	}

	public ListNode middleNode(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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

	private ListNode buildList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for (int i = 1; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			current.next = node;
			current = node;
		}
		return head;
	}

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
