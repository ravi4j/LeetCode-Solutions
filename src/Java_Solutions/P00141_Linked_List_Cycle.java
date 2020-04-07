/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00141_Linked_List_Cycle {
	public static void main(String[] args) {
		 ListNode head =  new ListNode(1);
		 head.next =  new ListNode(2);
		 head.next.next = head;
		P00141_Linked_List_Cycle solution = new P00141_Linked_List_Cycle();
		solution.printList(head);
		boolean cycle = solution.hasCycle(head);
		System.out.println("Has Cycle?..." + cycle);
	}

	public void printList(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			System.out.print(slow.val + " -> ");
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.print(slow.val + " -> ");
				System.out.println(fast.next.val);
				return;
			}
		}
		System.out.println();
		return;
	}

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
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
