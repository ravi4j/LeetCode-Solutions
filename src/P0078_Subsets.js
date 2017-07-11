/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
   let results = [];
    subsetHelper(nums , 0, [] , results);
    return results;  
};

var subsetHelper = function(nums , index , aset , results){
    if(index <= nums.length){
          results.push([].concat(aset));
    } 
    for(let i = index ; i < nums.length; i++){
        aset.push(nums[i]);
        subsetHelper(nums , i + 1 , aset , results);
        aset.pop();  
    }
};

let nums = [1 , 2, 3];
let result = subsets(nums);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}

nums = [];
result = subsets(nums);
for(let i = 0 ; i < result.length ; i++){
    console.log(result[i]);
}