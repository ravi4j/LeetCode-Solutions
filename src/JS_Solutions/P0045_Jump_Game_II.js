/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
	if(nums === null || nums.length === 0)
		return 0;
	var lreach  = 0, reach = 0 , steps = 0 , i = 0;
	while(i < nums.length){
		if( i > lreach){
			steps++;
			lreach = reach;
		}
		reach = Math.max(reach , i + nums[i]);
		//console.log(reach , lreach , steps , i);
		i++;
	}
	if(reach < nums.length - 1)
		return 0;
    return steps;
};

var nums = [2,3,1,1,4];
var result = jump(nums);
console.log(result);
