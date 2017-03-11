/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var n = s.length;
    if(n === 0) return 0;
    var ans = 0 , i = 0 , index = [];
    for(var c = 0 ; c <= 128 ; c++)
    	index[c] = 0;
    for(var j = 0 ; j < n ; j++){
    	var cIndex = index[s.charCodeAt(j)];
    	i = Math.max(cIndex , i);
    	ans = Math.max(ans , j - i + 1);
    	index[s.charCodeAt(j)] = j + 1;
    }
    return ans;
};


var INPUT = "pwwke";
var result = lengthOfLongestSubstring(INPUT);
console.log(result);