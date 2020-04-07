/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
	var saved={}
    var result=[]
    for(i=0; i< nums.length; i++){
      if(saved.hasOwnProperty(nums[i])){
        result[0] = saved[nums[i]];
        result[1] = i;
        return result
      }
      saved[target - nums[i]] = i
      console.log("saved :" + JSON.stringify(saved));
    }
  };

var hasTwoSum = function(nums , target) {
  	var i = 0 , j = nums.length - 1;
  	nums.sort(function(a ,b) { return a - b;});
  	while(i < j){
  		if(nums[i] + nums[j] === target)
  			return true;
  		else if (nums[i] + nums[j] < target)
  			i++;
  		else
  			j--;		
 	}
   	return false;
  };



var INPUT = [2, 7, 11, 15] , target = 9;
//var result = twoSum(INPUT ,target);
var result = hasTwoSum(INPUT ,target);
console.log(result);


var INPUT1 = [3, 1, 4] , target = 6;
//var result1 = twoSum(INPUT1 ,target);
var result1 = hasTwoSum(INPUT1 ,target);
console.log(result1);


