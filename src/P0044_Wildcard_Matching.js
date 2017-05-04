/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
	var T = [] , n = s.length , m = p.length;
	// Init array
	for(var i = 0 ; i <= n ; i++){
		T[i] = [];
		for(var j = 0 ; j<= m ; j++){
			T[i][j] = false;
		}
	}
	T[0][0] = true;	
	// Set first row
	for(i = 1 ; i <= n ; i++)
		T[i][0] = false;
	// Set first column
	for(j = 1 ; j <= m ; j++)
		T[0][j] = T[0][j-1] && (p.charAt(j-1) === '*');

	for(i = 0 ; i < n ; i++){
		for(j = 0 ; j < m ; j++){
			if(s.charAt(i) === p.charAt(j) || p.charAt(j) === '?'){
				T[i+1][j+1]  = T[i][j];
			} else if(p.charAt(j) === '*'){
				T[i+1][j+1] = T[i][j+1] || T[i+1][j];
			}else{
				T[i+1][j+1] = false;
			}
		}
	}
	return T[n][m];
};

/*
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

var s = "aa" , p="a";
var result = isMatch(s,p);
console.log(result);

s = "aa" , p="aa";
result = isMatch(s,p);
console.log(result);

s = "aaa" , p="aa";
result = isMatch(s,p);
console.log(result); 

s = "aa" , p="*";
result = isMatch(s,p);
console.log(result);

s = "aa" , p="a*";
result = isMatch(s,p);
console.log(result);

s = "ab" , p="?*";
result = isMatch(s,p);
console.log(result);

s = "aab" , p="c*a*b";
result = isMatch(s,p);
console.log(result);  

s = "c" , p="*?*"; // true
result = isMatch(s,p);
console.log(result); 

s = "b" , p ="??"; // false
result = isMatch(s,p);
console.log(result); 

s = "" , p ="*?*"; // false
result = isMatch(s,p);
console.log(result); 
