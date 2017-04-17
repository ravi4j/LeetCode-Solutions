/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    
    if(nums === null || nums.length === 0)
    	return [-1 , -1];

    var leftR = searchleft(nums , target);
    var rightR = searchRight(nums , target); 

    return [leftR , rightR];
};

var searchleft = function(nums , target){
	var l = 0 , r = nums.length - 1, result  = -1 , mid = 0;
	while(l <= r){
		mid = l + parseInt((r - l)/2);
		if(target === nums[mid]){
			result = mid;
			r = mid - 1;
		} else if( target < nums[mid]){
			r = mid - 1;
		} else {
			l = mid + 1;
		}
	}
	return result;
};

var searchRight = function(nums , target){
	var l = 0 , r = nums.length - 1, result  = -1 , mid = 0;
	while(l <= r){
		mid = l + parseInt(( r - l)/2);
		if(target === nums[mid]){
			result = mid;
			l = mid + 1;
		} else if( target < nums[mid]){
			r = mid - 1;
		} else {
			l = mid + 1;
		}
	}
	return result;
};

var nums = [5, 7, 7, 8, 8, 10] , target = 8;
var results = searchRange(nums , target);
console.log(" [ " + results.join(" , ") , " ]");

nums = [5, 7, 7, 8, 8, 10] , target = 7;
results = searchRange(nums , target);
console.log(" [ " + results.join(" , ") , " ]");

nums = [5, 7, 7, 8, 8, 10] , target = 11;
results = searchRange(nums , target);
console.log(" [ " + results.join(" , ") , " ]");

nums = [] , target = 11;
results = searchRange(nums , target);
console.log(" [ " + results.join(" , ") , " ]");