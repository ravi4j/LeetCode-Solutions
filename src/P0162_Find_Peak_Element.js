/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    return helper(nums, 0, nums.length - 1);
};

var helper = function(nums, start, end) {
    if (start === end)
        return start;
    else if (start + 1 === end)
        return (nums[start] > nums[end]) ? start : end;
    else {
        let mid = parseInt((start + end) / 2);
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;
        else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1])
            return helper(nums, start, mid - 1);
        else
            return helper(nums, mid + 1, end);
    }
};

let nums = [1, 2, 3, 1];
let result = findPeakElement(nums);
console.log(result);

nums = [1, 2, 3, 4, 5];
result = findPeakElement(nums);
console.log(result);

nums = [5, 4, 3, 2, 1];
result = findPeakElement(nums);
console.log(result);