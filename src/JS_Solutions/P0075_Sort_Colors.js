/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

const Colors = {"RED": 0 , "WHITE" : 1 , "BLUE" : 2};

var sortColors = function(nums) {
    if( nums === null || nums.length === 0)
        return;
    let n = nums.length , smaller = 0 , equal = 0 , larger = n;
    while( equal < larger){
        if(nums[equal] < Colors.WHITE){
            nums.swap(smaller++ , equal++);
        } else if( nums[equal] === Colors.WHITE){
            equal++;
        } else{
            nums.swap(--larger , equal);
        }
    }
};

Array.prototype.swap = function(i , j){
    let temp = this[i];
    this[i] = this[j];
    this[j] = temp;
};

let nums = [1,2,0,1,0,2];
sortColors(nums);
console.log(nums)

nums = [2 , 1 , 0];
sortColors(nums);
console.log(nums)

