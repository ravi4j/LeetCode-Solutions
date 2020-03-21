/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
	if(nums ===  null || nums.length === 0)
		return 0;
	var maxStartAt = nums[0] , maxSoFar = nums[0];
	for(var i = 1 ; i < nums.length ; i++){
		maxStartAt = Math.max( (maxStartAt + nums[i]) , nums[i]);
		maxSoFar = Math.max(maxStartAt , maxSoFar);
	}
	return maxSoFar;    
};

var nums = [-2,1,-3,4,-1,2,1,-5,4];
var result = maxSubArray(nums);
console.log(result);

var nums = [1,2];
var result = maxSubArray(nums);
console.log(result);
