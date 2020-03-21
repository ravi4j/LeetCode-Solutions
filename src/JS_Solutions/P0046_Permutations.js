/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
	var results = [];
	permuteHelper(nums , [] , results);
    return results;
};

var permuteHelper = function(nums , numberUsed , results){
	if(nums.length === numberUsed.length){
		results.push([].concat(numberUsed));
		return;
	}else {
		for(var i = 0 ; i < nums.length;i++){
			if(numberUsed.indexOf(nums[i]) != -1)
				continue;
			numberUsed.push(nums[i]);
			permuteHelper(nums, numberUsed , results);
			numberUsed.pop();
		}	
	}

};

var nums = [1,2,3];
var results = permute(nums);
for(var i = 0; i < results.length;i++)
	console.log(results[i]);