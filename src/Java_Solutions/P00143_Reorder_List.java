import java.util.List;

public class P00143_Reorder_List {
    public static void main(String[] args) {
        P00143_Reorder_List solution = new P00143_Reorder_List();
        int[] input = {1, 2, 3, 4};
        ListNode head = solution.buildList(input);
        solution.printList(head);
        solution.reorderList(head);
        solution.printList(head);
        int[] input1 = {1, 2, 3, 4,5};
        ListNode head1 = solution.buildList(input1);
        solution.printList(head1);
        solution.reorderList(head1);
        solution.printList(head1);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // find the middle
        ListNode mid = findMiddle(head);
        // break the second list
        ListNode second  = mid.next;
        mid.next = null;

        //reverse the second link
        second = reverse(second);

        // merge the two list
        mergeList(head , second);
    }

    public void mergeList(ListNode l1 , ListNode l2){
        while (l2 != null){
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }

    public ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow =slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        head.next = null;
        return pre;
    }

    public void printList(ListNode head) {
        if (head == null) return;
        for (ListNode current = head; current != null; current = current.next) {
            System.out.printf("%d -> ", current.val);
        }
        System.out.println("null");
    }

    public ListNode buildList(int[] inputs) {
        if (inputs == null || inputs.length == 0) {
            return null;
        }
        ListNode head = new ListNode(inputs[0]);
        ListNode current = head;
        for (int i = 1; i < inputs.length; i++) {
            ListNode node = new ListNode(inputs[i]);
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
