/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
var partition = function(head, x) {
    if (head === null)
        return head;
    var dummy1 = new ListNode(-1);
    var dummy2 = new ListNode(-1)
    var current = head,
        current1 = dummy1,
        current2 = dummy2;
    while (current !== null) {
        if (current.val < x) {
            current1.next = current;
            current1 = current;
        } else {
            current2.next = current;
            current2 = current;
        }
        current = current.next;
    }
    current2.next = null;
    current1.next = dummy2.next;
    return dummy1.next;
};

var ListNode = function(val) {
    this.val = val;
    this.next = null;
};

//1->4->3->2->5->2
var list = new ListNode(1);
list.next = new ListNode(4);
list.next.next = new ListNode(3);
list.next.next.next = new ListNode(2);
list.next.next.next.next = new ListNode(5);
list.next.next.next.next.next = new ListNode(2);

var printList = function(head) {
    var current = head;
    var str = "";
    while (current !== null) {
        str += current.val;
        if (current.next != null)
            str += "->"
        current = current.next;
    }
    console.log(str);
};

printList(list);
list = partition(list, 3);
printList(list);