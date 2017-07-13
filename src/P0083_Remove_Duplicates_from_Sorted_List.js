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
    if(head === null || head.next === null)
        return head;
    let current = head;
    while(current !== null){
        while(current.next !== null && current.val === current.next.val)
            current.next = current.next.next;
        current = current.next;    
    } 
    return head;
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
 LIST.next = new ListNode(1);
 LIST.next.next = new ListNode(2);
 LIST.next.next.next = new ListNode(3);
 LIST.next.next.next.next = new ListNode(3);
 LIST.next.next.next.next.next = new ListNode(3);
 
 printList(LIST);
 deleteDuplicates(LIST);
 printList(LIST);
