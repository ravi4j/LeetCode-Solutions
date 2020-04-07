/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if( nums === null || nums.length < 2 )
    	return nums !== null ? nums.length : 0;
    var idx = 1 , n = nums.length , atMost = 2 , count = 1;
    for(var i = 1 ; i < n ; i++){
    	if(nums[i - 1]  === nums[i]) {
            if(count < atMost) {
              nums[idx] = nums[i];
    		  idx++; count++;   
            } else {
    		    continue;
            }    
    	} else {
    		nums[idx] = nums[i];
    		idx++; count = 1;
    	}
    }
    return idx;
};

var INPUT = [1,1,1,2,2,3];
var result = removeDuplicates(INPUT);
console.log(result);

var INPUT2 = [1,1,1,1,2,2,2,3,3, 4];
var result2 = removeDuplicates(INPUT2);
console.log(result2);