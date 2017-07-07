/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    var l = 0 , r = x , mid = 0 , sqr = 0;
    while(l <= r){
    	mid = l + parseInt(( r - l) / 2);
    	sqr = mid * mid;
    	if( sqr <= x){
    		l = mid + 1;
    	} else {
    		r = mid - 1;
    	}
    }
    return parseInt(l) - 1;
};

var x = 25;
var result = mySqrt(x);
console.log(result);