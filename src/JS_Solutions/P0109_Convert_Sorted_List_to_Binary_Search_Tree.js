/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {
    // write your code here
    if (head == null) {
        return null;
    }

    if (head.next == null) {
        return new TreeNode(head.val);
    }

    var slow = head;
    var fast = head;
    var pre = head;

    while (fast != null && fast.next != null) {
        pre = slow;
        slow = slow.next;
        fast = fast.next.next;
    }

    var root = new TreeNode(slow.val);
    pre.next = null;
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
};


var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};

var ListNode = function(val) {
    this.val = val;
    this.next = null;
};

var printList = function(list) {
    if (list === null) {
        return;
    }
    var current = list;
    var result = [];
    while (current !== null) {
        result.push(current.val);
        current = current.next;
    }
    console.log(result);
    return result;
}

var list = new ListNode(-10);
list.next = new ListNode(-3);
list.next.next = new ListNode(0);
list.next.next.next = new ListNode(5);
list.next.next.next.next = new ListNode(9);

printList(list);

var root = sortedListToBST(list);

var inorderTraversal = function(root) {
    var holder = [];
    inorderTraversalHelper(root, holder);
    return holder;
};

var inorderTraversalHelper = function(root, holder) {
    if (root === null)
        return;
    inorderTraversalHelper(root.left, holder);
    holder.push(root.val);
    inorderTraversalHelper(root.right, holder);
}

var result = inorderTraversal(root);
console.log(result);