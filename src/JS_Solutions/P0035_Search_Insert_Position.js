/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    return search(nums, 0, nums.length - 1, target);
};

var search = function(nums , start , end , target){
	if( start > end) return start;
	
	var mid = parseInt(( start + end) / 2);
	if(target === nums[mid]) 
		return mid;
	else if (target < nums[mid])
		return search(nums , start , mid - 1 , target);
	else
		return search(nums , mid + 1, end, target);
};




var nums = [1,3,5,6] , target = 5;
var result = searchInsert(nums , target);
console.log(result);

target = 2
result = searchInsert(nums , target);
console.log(result);

target = 7
result = searchInsert(nums , target);
console.log(result);

target = 0
result = searchInsert(nums , target);
console.log(result); 