/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    let results = [];
    nums = nums.sort();
    subsetHelper(nums, 0, [], results);
    return results;
};

var subsetHelper = function(nums, index, aset, results) {
    if (index <= nums.length) {
        results.push([].concat(aset));
    }
    for (let i = index; i < nums.length; i++) {
        aset.push(nums[i]);
        subsetHelper(nums, i + 1, aset, results);
        aset.pop();
        while (i < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
    }
};

let nums = [2, 1, 2];
let result = subsetsWithDup(nums);
for (let i = 0; i < result.length; i++) {
    console.log(result[i]);
}

nums = [1, 2, 3];
result = subsetsWithDup(nums);
for (let i = 0; i < result.length; i++) {
    console.log(result[i]);
}