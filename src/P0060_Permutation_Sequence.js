/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */

var FACT = [1, 1, 2, 6, 24 , 120 , 720 , 5040 , 40320 , 362880 ];

var getPermutation = function(n, k) {
	var nums = [] , start = 1;
	var result = [] , index = -1 , f;
	for(var i = 0 ; i < n ; i++)
		nums[i] = start++;
	k = k -1;
	 while(nums.length !== 0){
	 	 f = FACT[nums.length - 1];	
	 	 index = parseInt(k / f);
	 	 result.push(nums[index]);
	 	 nums.splice(index, 1);
	 	 k %= f;
	 }	 
	 return result.join('');
};


var result = getPermutation( 3 , 6);
console.log(result);

