/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
    if (head === null)
        return head;
    let dummy = new ListNode(-1);
    dummy.next = head;
    let slow = dummy,
        current = head;
    while (current !== null) {
        while (current.next !== null && current.val === current.next.val) {
            current = current.next;
        }
        if (slow.next === current) {
            slow = slow.next;
        } else {
            slow.next = current.next;
        }
        current = current.next;
    }
    return dummy.next;
};

var ListNode = function(val) {
    this.val = val;
    this.next = null;
}

var head = new ListNode(1);
var l1 = new ListNode(1);
head.next = l1;
var l2 = new ListNode(1);
l1.next = l2;
var l3 = new ListNode(2);
l2.next = l3;
var l4 = new ListNode(3);
l3.next = l4;

var printList = function(list) {
    if (list === null) return;
    let current = head;
    let str = '';
    while (current !== null) {
        str += current.val + '->';
        current = current.next;
    }
    str += 'null'
    console.log(str);
};

printList(head);
head = deleteDuplicates(head);
printList(head);