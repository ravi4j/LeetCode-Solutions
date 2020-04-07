/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function(head, m, n) {
    if (head === null || head.next === null) {
        return head;
    }
    var dummy = new ListNode(0);
    dummy.next = head;
    var pre = dummy;
    for (let i = 0; i < m - 1; i++) {
        pre = pre.next;
    }
    var start = pre.next;
    var then = start.next;
    for (let i = 0; i < n - m; i++) {
        start.next = then.next;
        then.next = pre.next;
        pre.next = then;
        then = start.next;
    }
    return dummy.next;
};

var ListNode = function(val) {
    this.val = val;
    this.next = null;
};

var printList = function(list) {
    var node = list,
        str = "";
    while (node !== null) {
        str += node.val;
        if (node.next !== null) {
            str += "->";
        }
        node = node.next;
    }
    console.log(str);
};

var LIST = new ListNode(1);
LIST.next = new ListNode(2);
LIST.next.next = new ListNode(3);
LIST.next.next.next = new ListNode(4);
LIST.next.next.next.next = new ListNode(5);
LIST.next.next.next.next.next = new ListNode(6);

printList(LIST);
reverseBetween(LIST, 2, 4);
printList(LIST);