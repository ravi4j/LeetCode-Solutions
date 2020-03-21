/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {

	if(lists.length === 0) return null;

	var last = lists.length - 1;
	while(last !== 0){
		var i = 0 , j = last;
		while(i < j){
			lists[i] = merge(lists[i] , lists[j]);
			i++;
			j--;
			if(i >=j)
				last = j;
		}

	}
    
    return lists[0];
};

var merge = function(l1,l2){
	if(l2 === null) 
		return l1;
	if(l1 === null)
		return l2;
	var result  = null;
	if(l1.val <= l2.val){
		result = l1;
		result.next = merge(l1.next , l2);
	} else {
		result = l2;
		result.next = merge(l1, l2.next);
	}

	return result;
}

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


 var l1 = new ListNode(1);
 l1.next = new ListNode(2);
 var l2 = new ListNode(3);
 l2.next = new ListNode(4);
 var l3 = new ListNode(5);
 l3.next = new ListNode(6);
 printList(l1);
 printList(l2);
 printList(l3);
 var input_lists = [l1,l2,l3] ;
 var result = mergeKLists(input_lists);
 printList(result);

 var input_lists = [] ;
 var result = mergeKLists(input_lists);
 printList(result);