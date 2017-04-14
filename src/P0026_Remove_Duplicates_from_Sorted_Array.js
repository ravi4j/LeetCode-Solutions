/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if( nums === null || nums.length < 2 )
    	return nums !== null ? nums.length : 0;
    var idx = 1 , n = nums.length;
    for(var i = 1 ; i < n ; i++){
    	if(nums[i - 1]  === nums[i]) {
    		console.log("equal" , nums[i - 1] , nums[i] , i );
    		continue;
    	} else {
    		console.log("not equal" , nums[i - 1] , nums[i] , idx );
    		nums[idx] = nums[i];
    		idx++;
    	}
    }
    return idx;
};

var INPUT = [1,1,2];
var result = removeDuplicates(INPUT);
console.log(result);

var INPUT2 = [1,1,1,1,2,2,2,3,3, 4];
var result2 = removeDuplicates(INPUT2);
console.log(result2);