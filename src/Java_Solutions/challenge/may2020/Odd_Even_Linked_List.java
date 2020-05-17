package challenge.may2020;

import java.util.stream.IntStream;

public class Odd_Even_Linked_List {
    public static void main(String[] args) {
        Odd_Even_Linked_List solution = new Odd_Even_Linked_List();
        ListNode head = solution.buildList(IntStream.of(1, 2, 3, 4, 5).toArray());
        solution.printList(head);
        head = solution.oddEvenList(head);
        solution.printList(head);

        ListNode head2 = solution.buildList(IntStream.of(2, 1, 3, 5, 6, 4, 7).toArray());
        solution.printList(head2);
        head2 = solution.oddEvenList(head2);
        solution.printList(head2);

    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode connectNode = even;
        while (odd != null && even != null) {
            ListNode temp = even.next;
            if(temp == null){
                break;
            }

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = connectNode;
        return result;
    }


    private void printList(ListNode head) {
        if (head == null) {
            return;
        }
        for (ListNode current = head; current != null; current = current.next) {
            System.out.printf("%d -> ", current.val);
        }
        System.out.println(" null");
    }

    private ListNode buildList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        return head;
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
