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
  }


var INPUT = [2, 7, 11, 15] , target = 9;
var result = twoSum(INPUT ,target);
console.log(result);


var INPUT = [3, 2, 4] , target = 6;
var result = twoSum(INPUT ,target);
console.log(result);
