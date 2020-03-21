/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    
    if(nums.length < 2)
    	return;

    var k = nums.length - 2;

    while( k >= 0 && nums[k] >= nums[k + 1]){
    	k--;
    }

    if(k === -1){
    	reverse(nums , 0 , nums.length - 1);
    	return;
    }

    var l = nums.length - 1;
    while(l > k && nums[l] <= nums[k]){
    	l--;
    }

    //swap k , l 
    var temp = nums[l];
    nums[l] = nums[k];
    nums[k] = temp;

    reverse(nums , k + 1 , nums.length - 1);
};

var reverse = function(nums , start , end){
	var i = start ,  j = end;
    while(i < j ){
    	temp = nums[i];
   		nums[i] = nums[j];
    	nums[j] = temp;
    	i++;
    	j--;
    }
};


var nums = [1,2,3];
nextPermutation(nums);
console.log(" [ " + nums.join(" , ") + " ] ");

nums = [3,2,1];
nextPermutation(nums);
console.log(" [ " + nums.join(" , ") + " ] ");

nums = [1,1,5];
nextPermutation(nums);
console.log(" [ " + nums.join(" , ") + " ] ");
