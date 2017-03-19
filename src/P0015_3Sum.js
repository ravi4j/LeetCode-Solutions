/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    var n = nums.length;
    if( n < 3) return [];
    nums.sort(function(a,b) {return a - b;});
    var res = [] ,  idx = 0;
    for(var i = 0 ; i < n - 2; i++){
    	if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
            continue;
        }
        var j = i + 1 , k = n - 1;
        while(j < k) {
            var sum = nums[i] + nums[j] + nums[k];
            if( sum === 0){
            	res[idx++] = [nums[i] , nums[j] , nums[k]];
            	j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
            }
            else if(sum < 0){
              j++
            }
            else{
                k--;    
            }
        }
    }
    return res;
};


/*For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

var INPUT  = [-1, 0, 1, 2, -1, -4];
var result = threeSum(INPUT);
for(var i = 0 ; i < result.length ; i++)
	console.log(" [ " + result[i].join(" , ") + " ]");