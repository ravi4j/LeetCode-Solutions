public class P00138_Copy_List_with_Random_Pointer {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head; // 7
        head.next.next.random = head.next.next.next.next; // 1
        head.next.next.next.random = head.next.next; // 11
        head.next.next.next.next.random = head;
        P00138_Copy_List_with_Random_Pointer solution = new P00138_Copy_List_with_Random_Pointer();
        solution.printList(head);
        Node copy = solution.copyRandomList(head);
        solution.printList(copy);
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //Copy nodes and insert it into list.
        Node p = head;
        while (p != null) {
            Node copy = new Node(p.val);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        // Resolve Random Pointers
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // Break the list into two
        p = head;
        Node clone = head.next;
        while (p != null) {
            Node temp = p.next;
            p.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            p = p.next;
        }

        return clone;
    }

    public void printList(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("[ next : ");
        Node current = node;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.print("null , random : ");

        current = node;
        while (current != null) {
            if (current.random != null) {
                System.out.print(current.random.val + "->");
            } else {
                System.out.print(null + "<-");
            }
            current = current.next;
        }
        System.out.println("null ]");
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
