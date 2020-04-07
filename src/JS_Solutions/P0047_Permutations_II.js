/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
	var results = [] , used = [];
	nums.sort(function(a,b){return a - b;});
	for(var i =0; i <nums.length; i++){
		used[i] = false;
	}
	permuteHelper(nums , [] , results , used);
    return results;
};

var permuteHelper = function(nums , numberUsed , results , used){
	console.log(used);
	if(nums.length === numberUsed.length){
		results.push([].concat(numberUsed));
		return;
	}else {
		for(var i = 0 ; i < nums.length; i++){
			if( used[i] || i > 0 && nums[i-1] === nums[i] && !used[i - 1] ){
				continue;
			}
			used[i] = true;
			numberUsed.push(nums[i]);
			permuteHelper(nums, numberUsed , results , used);
			used[i] = false;
			numberUsed.pop();
		}	
	}

};

var nums = [2,1,1];
var results = permute(nums);
for(var i = 0; i < results.length;i++)
	console.log(results[i]);