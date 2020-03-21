/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {

	if( k <=1 || head === null || head.next === null)
		return head;

	 //judge the length of group
	var prev = head;
    for(var i = 0; i < k; i++) {
       if(prev === null) 
       	  return head;
       prev = prev.next;
    }
    
    var dummy = new ListNode(-1);
    dummy.next = head ; prev = dummy;
    var current = prev.next , j = k - 1;
    while(j > 0 ){
    	var temp = current.next;
    	current.next = temp.next;
    	temp.next = prev.next;
    	prev.next = temp;
	     j--;	
    }

    current.next = reverseKGroup(current.next , k);
    return dummy.next;
};


var ListNode = function(val) {
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
 var k = 2;
 var result = reverseKGroup(LIST , k);
 printList(result); 

 var LIST1 = new ListNode(1);
 LIST1.next = new ListNode(2);
 printList(LIST1);
 k = 3;
 var result = reverseKGroup(LIST1 , k);
 printList(result); 

 LIST = new ListNode(1);
 LIST.next = new ListNode(2);
 LIST.next.next = new ListNode(3);
 printList(LIST);
 k = 2;
 var result = reverseKGroup(LIST , k);
 printList(result); 