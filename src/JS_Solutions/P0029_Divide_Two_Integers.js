/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var MAX_VALUE =  2147483647;
var MIN_VALUE = -2147483648;
var divide = function(dividend, divisor) {
	var sign = 1;
	if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) 
		sign = -1;
	
	var absDividend = Math.abs(dividend);
	var absDivisor = Math.abs(divisor);

	if(absDividend === 0 || (absDividend < absDivisor)) return 0;
	if(absDivisor === 0) return Number.MAX_VALUE;
	var absDiv = ldivide(absDividend , absDivisor);
	if( absDiv > MAX_VALUE)	
        absDiv = sign === 1 ? MAX_VALUE : MIN_VALUE;
     else
     	absDiv = sign * absDiv;
     
     return absDiv;
};

var ldivide = function(dividend , divisor){
	if(dividend < divisor )
		return 0;
	var div = divisor , q = 1;
	while(div <= (dividend >> 1)){
		div = div << 1;
		q = q << 1;	
	}
	return q + ((div === dividend) ? 0 : ldivide((dividend - div) , divisor));
};



var dividend = -2147483648 , divisor = -1;
var result = divide(dividend , divisor);
console.log(result);
dividend = 2147483647 , divisor = 3;
result = divide(dividend , divisor);
console.log(result);