/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    if(nums === null || nums.length < 4)
    	return [];
    nums.sort(function(n1 ,n2) {
    	return n1 - n2;
    });
    var result = [] , idx = 0 , n = nums.length;
    for(var i = 0 ; i < n - 3 ; i++){
    	if (i !== 0 && nums[i] == nums[i - 1]) {              // skip same result
            continue;
        }   
    	for(var j = i + 1 ; j < n - 2; j++){
    		if (j != i + 1 && nums[j] == nums[j - 1]) {              // skip same result
           		 continue;
        	}
    		var left = j + 1 , right = n - 1;
    		while(left < right){
    			var sum = nums[i] + nums[j] + nums[left] + nums[right];
    			if(sum === target){
    				result[idx++] = [ nums[i] , nums[j] , nums[left] , nums[right] ];
    				left++;
    				right--;
    				while(left < right && nums[left] === nums[left - 1])
    					left++;
    				while(left < right && nums[right] === nums[right + 1])
    					right--;
    			} else if( sum < target){
    				left++;	
    			}	else if(sum > target){
    				right--;
    			}
    		}
    	}		
    }
    return result;
};


//var INPUT = [-3,-2,-1,0,0,1,2,3] , target = 0;
//var INPUT = [1, 0, -1, 0, -2, 2] , target = 0;
var INPUT = [0,0,0,0], target = 0;
var result = fourSum(INPUT ,target);
for(var i = 0 ; i < result.length ; i++)
	console.log("[ " + result[i].join(" , ") + " ]");

/*Output:
[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Expected:
[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
*/