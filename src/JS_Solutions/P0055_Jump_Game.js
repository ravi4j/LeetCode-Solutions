/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
	 var reachable = 0;
    for (var i=0; i<nums.length; ++i) {
        if (i > reachable) return false;
        reachable = Math.max(reachable, i + nums[i]);
    }
    return true;
};

var A = [2,3,1,1,4];
var result = canJump(A);
console.log(result);

 A = [3,2,1,0,4];
result = canJump(A);
console.log(result);


 A = [2,5,0,0];
result = canJump(A);
console.log(result);

 A = [0];
result = canJump(A);
console.log(result);

