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
var mergeTwoLists = function(l1, l2) {
	if(l1 === null && l2 === null) return null;
	if(l1 === null && l2 !== null) return l2;
	if(l1 !== null && l2 === null) return l1;
	var dummy = new ListNode(-1) , list = dummy, list1 = l1 , list2 = l2;
	while(list1 !== null && list2 !== null ){
		if(list1.val < list2.val ){
			list.next = new ListNode(list1.val);
			list1 = list1.next;
		} else if (list1.val > list2.val){
			list.next = new ListNode(list2.val);
			list2 = list2.next;
		} else {
			list.next = new ListNode(list2.val);
			list2 = list2.next;
		}
		list = list.next;
	}
    if(list1 !== null)
    	list.next = list1;
    if(list2 !== null)
    	list.next = list2;

    return dummy.next;
};

var ListNode = function ListNode(val) {
   this.val = val;
   this.next = null;
 };

printList = function(l){
	var str = "" , node = l;
	while(node !== null){
		str +=node.val;
		if(node.next != null) 
			str += " -> ";
		node = node.next;
	}
	console.log(str);
	return str;
}

 var l1 = new ListNode(1);
 l1.next = new ListNode(3);
 printList(l1);
 var l2 = new ListNode(2);
 l2.next = new ListNode(5);
 printList(l2);
 var result = mergeTwoLists(l1,l2);
 printList(result);
