/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
 if( nums === null )
    	return 0;
    var idx = 0 , n = nums.length;
    for(var i = 0 ; i < n ; i++){
      if( nums[i] !== val)
      	nums[idx++] = nums[i];			
    }
   return idx;   	
};


var nums = [3,2,2,3] , val = 3;
var result = removeElement(nums , val);
console.log(result);


nums = [3] , val = 3;
result = removeElement(nums , val);
console.log(result);