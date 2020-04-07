/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
	if(nums.length === 0)
		return 1;
 	var i = 0;
    while(i < nums.length){
        if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) 
        	i++;
        else if(nums[nums[i] - 1] != nums[i]) 
        	swap(nums, i, nums[i]-1);
        else i++;
         console.log(" aa" , nums , i );
    }
    console.log(nums);
    i = 0;
    while(i < nums.length && nums[i] == i+1) i++;
    return i+1;
};



var swap = function(nums , i , j){
	var temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp; 
};


var nums = [-1,-1,-1];
var result = firstMissingPositive(nums);
console.log(result);

nums = [3,4,-1,1];
result = firstMissingPositive(nums);
console.log(result);
