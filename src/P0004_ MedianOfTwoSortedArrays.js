/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
	var A = nums1 , B = nums2 , m =  nums1.length , n = nums2.length;
	if( m > n){
		A = nums2; B = nums1; m = nums2.length; n = nums1.length;
	}
	var imin = 0 , imax = m  , half_len = Math.floor(( m + n + 1) / 2);
	while( imin <= imax){
		var i = Math.floor((imin + imax) / 2),
			j = half_len - i;
		if( i < m && A[i] < B[j-1] ){
			imin = i + 1;
		} else if( i > 0 && A[i - 1] > B[j]){		
			imax = i - 1;
		} else {
			if( i === 0 ) 
				max_of_left = B[j-1];
			else if(j === 0) 
				max_of_left = A[i-1];
			else
				max_of_left = Math.max(A[i-1] ,B[j-1]);	

			if((m + n) % 2 === 1){
				return max_of_left;
			}

			if(i === m) 
				min_of_right = B[j];
			else if( j === n) 
				min_of_right = A[i];
			else
				min_of_right = Math.min(A[i] , B[j]);
			return (max_of_left + min_of_right) / 2;
		}
	}
	
 
    
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
