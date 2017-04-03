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
var swapPairs = function(head) {
   
     if(head === null || head.next === null)   
        return head;
 
    var h = new ListNode(0);
    h.next = head;
    var p = h;
 
    while(p.next !== null && p.next.next !== null){
        //use t1 to track first node
        var t1 = p;
        p = p.next;
        t1.next = p.next;
 
        //use t2 to track next node of the pair
        var t2 = p.next.next;
        p.next.next = p;
        p.next = t2;
    }
 
    return h.next;
};

// h -> 1 -> 2 -> 3 -> 4
// p -> h -> 1 -> 2 -> 3 -> 4
// t1 -> h , p -> 1
// t1 -> h -> 2
// t2 -> 2 
// 2 -> 1
// h -> 2
// h -> 2 -> 1 -> 3 -> 4
//      p -> 1 -> 3 -> 4 

var ListNode = function ListNode(val) {
    this.val = val;
    this.next = null;
 };

 var printList = function(list){
 	var node = list , str = "";
 	 while(node !== null){
 		str += node.val;
 		if(node.next !== null)
 			str += " -> ";
 		node = node.next;
 	}	
 	console.log(str);
 	return str;
 };

var LIST = new ListNode(1);
LIST.next = new ListNode(2);
LIST.next.next = new ListNode(3);
LIST.next.next.next = new ListNode(4);
printList(LIST);
var result = swapPairs(LIST);
printList(result); 