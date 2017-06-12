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
var rotateRight = function(head, k) {
	if( head === null)
		return head;
	var dummy = new ListNode(-1);
	dummy.next = head;
	var fast = dummy , slow = dummy , n = 0;
	 while(fast.next !== null){
	   fast = fast.next;
	   n++;
	  } 
	if( k > n)
		k %= n;
	if( k === 0  || k === n)
		return head;
	 var j =  n - k ;  	
	 while( j > 0){
	 	slow = slow.next;	
	 	j--;
	 }  	
	 fast.next = dummy.next;
	 dummy.next = slow.next;
	 slow.next = null;
	return dummy.next;		    
};


var ListNode = function ListNode(val) {
      this.val = val;
      this.next = null;
 };

 var printList = function(list){
 	var curr = list , str = '';
 	while(curr !== null){
 		str += curr.val + '->';
 		curr = curr.next;
 	}
 	console.log(str);
 };

 var list = new ListNode(1);
  list.next = new ListNode(2);
  list.next.next = new ListNode(3);
  list.next.next.next = new ListNode(4) ;
  list.next.next.next.next = new ListNode(5);
  printList(list);
  list = rotateRight(list , 10);
 printList (list);