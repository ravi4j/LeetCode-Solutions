/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
	if(strs.length === 0) return "";
    var minLen = findMinlenght(strs);
    var prefix = "" , low = 1 , high = minLen;
    while( low <= high){
      var mid =  Math.floor((high + low) / 2);
      if(isContainAllPrefix(strs, mid)){
      		low = mid + 1;
       } else {
       		high = mid - 1;
       }
    }
	return strs[0].substring(0, (low + high) / 2);
};

var isContainAllPrefix= function(strs , len){
	var str = strs[0].substring(0,len);
	for(var i = 1; i < strs.length ; i++){
		if(!strs[i].startsWith(str)){
			return false;	
		}
	}
	return true;
}

var findMinlenght = function(strs){
	var min = strs[0].length;
	for(var i = 1 ; i < strs.length; i++){
		if(strs[i].length < min) 
			min = strs[i].length;
	}
	return min;
}

var INPUT = ["geeksforgeeks", "geeks", "geek", "geezer"];
var result = longestCommonPrefix(INPUT);
console.log(result);

var INPUT2 = ["aa", "aa", "aa", "aa"];
var result2 = longestCommonPrefix(INPUT2);
console.log(result2); 

var INPUT3 = ["flower","flow","flight"];
var result3 = longestCommonPrefix(INPUT3);
console.log(result3);