package leetcode;

public class P00147_Insertion_Sort_List {
	public static void main(String[] args) {
		P00147_Insertion_Sort_List solution = new P00147_Insertion_Sort_List();
		int[] input = { 4, 2, 1, 3 };
		ListNode head = solution.buildList(input);
		solution.printList(head);
		ListNode sorted = solution.insertionSortList(head);
		solution.printList(sorted);
	}

	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode sorted = null;
		ListNode current = head;
		while(current != null){
			ListNode node = current.next;
			sorted = addIntoSorted(sorted , current);
			current = node;
		}
		return sorted;
	}

	private ListNode addIntoSorted(ListNode sorted , ListNode node ){
		// node should be added into before sorted head
		if(sorted == null || sorted.val >= node.val){
			node.next = sorted;
			sorted = node;
		} else {
			ListNode current = sorted;
			while(current.next != null && current.next.val < node.val){
				current = current.next;
			}
			node.next = current.next;
			current.next = node;
		}
		return sorted;
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
