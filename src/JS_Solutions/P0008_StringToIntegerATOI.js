/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    var base = 0 , idx = 0 , sign = 1;
    while(str.charAt(idx) === ' ') { idx++;}
    if(str.charAt(idx) === '+' || str.charAt(idx) === '-'){
    	if(str.charAt(idx) === '-')
    		sign = -1;
    	idx++;
    }
    while (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
    	base = 10 * base + (str.charAt(idx) - '0');
    	idx++;
    }
     //return base * sign;
     // if 32-bit...take care of overflow
    return Math.max(Math.min(base * sign || 0, 2147483647), -2147483648);
};

var myAtoiInOneLine = function(str) {
    return Math.max(Math.min(parseInt(str) || 0, 2147483647), -2147483648);
};

var INPUT = "2147483648";
var result = myAtoi(INPUT);
console.log(result);
if(result == parseInt(INPUT))
	console.log("Converted successfully to Integer value");
else
	console.log("Something went wrong !!!");