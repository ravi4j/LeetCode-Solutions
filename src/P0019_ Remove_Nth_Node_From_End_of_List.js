/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if(head === null) return head;
    var slow = head , fast = head , k = n;
    while( k > 0){
    	fast = fast.next;
    	k--;
    }
    if(fast === null) {
    	head = head.next;
    	return head;
    }
    slow = head , fast = fast.next;
    while(fast !== null){
    	fast = fast.next;
    	slow = slow.next;
    }
    if(slow.next !== null)
    	slow.next = slow.next.next;
    return head;
};

var ListNode = function ListNode(val) {
    this.val = val;
    this.next = null;
 };


 var printList = function(list){
 	var node = list , str = "";
 	 while(node !== null ){
 		str += node.val + "->";
 		node = node.next;
 	}	
 	console.log(str);
 };

var LIST = new ListNode(1);
 LIST.next = new ListNode(2);
 LIST.next.next = new ListNode(3);
 LIST.next.next.next = new ListNode(4);
 LIST.next.next.next.next = new ListNode(5);
 printList(LIST);
 var n = 2;
 var result = removeNthFromEnd(LIST , n);
 printList(result); 

/*
 var LIST = new ListNode(1);
 LIST.next = new ListNode(2);
 printList(LIST);
 var n = 1;
 var result = removeNthFromEnd(LIST , n);
 printList(result);
 */


