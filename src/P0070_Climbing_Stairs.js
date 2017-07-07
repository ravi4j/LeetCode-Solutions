/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
	if( n === 0) return 0;
	if(n === 1) return 1;
    var t = [1 , 1] , index = 2;
    while( index <= n){
    	t[index] = t[index - 1] + t[index - 2];
    	index++;
    }
    return t[n];
};

var n = 2;
var result = climbStairs(n);
console.log(result);

var n = 4;
var result = climbStairs(n);
console.log(result);