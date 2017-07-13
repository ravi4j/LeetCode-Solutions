/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function(nums, target) {
    
    if( nums === null || nums.length === 0)
    	return false;

    if(nums.length <= 2){
    	if(nums[0] === target) 
    		return true; 
    	else if(nums[1] === target)
    		return true;
    	else
    		return false;

    }

    var k =  nums.length - 2;
    
    while( k >=0 && nums[k] <= nums[k + 1]){
    	k--;
    }
  
    if(k >= 0){
    	if(target >= nums[0] && target <= nums[k]){
    		return binarySearch(nums , 0 , k , target) !== -1 ? true : false;
    	}
    	else if(target >= nums[k+1] && target <= nums[nums.length - 1]){
    		return binarySearch(nums , k + 1 , nums.length  , target) !== -1 ? true : false;
    	}
    	else{
    		return false;
    	}

    } else {
     	return binarySearch(nums , 0 , nums.length - 1 , target) !== -1 ? true : false;
    }	
};

var binarySearch = function(nums , l , r , target){
 var left = l , right = r , mid = l +  parseInt( (r - l) / 2);
  while(left <=  right){
  	if(target < nums[mid]){
  		right = mid  - 1;
  	}else if(target > nums[mid]){
  		left = mid + 1; 
  	} else if(target === nums[mid]) {
  		return mid;
  	}
  	mid = left + parseInt((right - left) / 2);
  }	
  return -1;
};

let nums  = [1, 1, 3, 4, 5, 5, 6, 7,7] , target = 10;
let result = search(nums , target);
console.log(result); 