/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    var n = nums.length;
    if( n < 3) return 0;
    nums.sort(function(a,b) {return a - b;});
    var res = nums[0] + nums[1] + nums[2];
    for(var i = 0 ; i < n - 2; i++){
        var j = i + 1 , k = n - 1;
        while(j < k) {
            var sum = nums[i] + nums[j] + nums[k];
            if(sum < target)
                j++;
            else
                k--;    
          if(Math.abs(sum - target) < Math.abs(res - target))
               res = sum;
        }
    }
    return res;
};


 //For example, given array S = {-1 2 1 -4}, and target = 1.

//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

var INPUT = [-1 , 2, 1, -4] , target = 1;
var result = threeSumClosest(INPUT , target);
console.log(result);