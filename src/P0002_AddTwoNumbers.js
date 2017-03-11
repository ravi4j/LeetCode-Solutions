/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
   var dummy = new ListNode(0);
   var q1 = l1 , q2 = l2 , curr = dummy , carry = 0;
	while(q1 !== null || q2 !== null){
		var v1 = (q1 !== null) ? q1.val : 0;
		var v2 = (q2 !== null) ? q2.val : 0;
		var sum = v1 + v2 + carry;
		curr.next = new ListNode(sum % 10);
		carry = Math.floor(sum / 10);
		q1 = (q1 !== null) ? q1.next : null;
		q2 = (q2 !== null) ? q2.next : null;
		curr = curr.next;
	}
    if(carry > 0)
    	curr.next = new ListNode(carry);

    return dummy.next; 
};

var ListNode = function(val) {
	this.val = val;
	this.next = null;
}

var printList = function(node) {
	var str ="";
	while(node !== null){
		str += node.val ;
		node = node.next;
		if( node != null)
			str += "->";
	}
		console.log(str);
}
	

var l1 = new ListNode(2);
l1.next = new ListNode(4);
l1.next.next = new ListNode(3);
printList(l1);

var l2 = new ListNode(5);
l2.next = new ListNode(6);
l2.next.next = new ListNode(4);
printList(l2)

var result = addTwoNumbers(l1 ,l2);
printList(result);