/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    return haystack.indexOf(needle);
};


var strStr1 = function(haystack, needle) {
	
	if( needle === null) 
		return -1;
	
	if((haystack === "" && needle === "") || (haystack !== "" && needle === ""))
		return 0;

	var n  = haystack.length , m = needle.length;
	for(var i = 0; i < n - m + 1; i++){
		var idx = i , j = 0 ;
		 while( j < m && haystack.charAt(idx) === needle.charAt(j))
		 {
		 	if(j === m - 1){
				return i;
			}
			idx++;
			j++;
		}
	}
    return -1;
};



var s1 = "a" , s2 = "";
var result = strStr(s1 ,s2);
console.log(result);