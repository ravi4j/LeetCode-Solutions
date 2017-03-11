/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    
};

var nums1 = [1, 3]
var nums2 = [2]
var result = findMedianSortedArrays(nums1 ,nums2);
console.log("The median is" +  result); //2.0

nums1 = [1, 2]
nums2 = [3, 4]
result = findMedianSortedArrays(nums1 ,nums2);
console.log("The median is" +  result); // (2 + 3)/2 = 2.5

ums1 = [1, 2 ,3 ,4,7]
nums2 = [0,5,6, 9]
result = findMedianSortedArrays(nums1 ,nums2);
console.log("The median is" +  result); // 
