/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
	if(a === null || a.length === 0)
		return b;
	if(b === null || b.length === 0)
		return a;
	var result = [];
	var carry = 0 , i = a.length - 1, j = b.length - 1 , p0 = 0 , p1 = 0 , sum = 0;
	while(i >=0 || j >= 0){
		p0 = (i >= 0) ? a.charAt(i--) - '0' : 0;
		p1 = (j >= 0) ? b.charAt(j--) - '0' : 0;
		sum = p0 + p1 + carry;
		console.log(sum);
		carry = sum > 1 ? 1 : 0;	
		sum %=2;
		result.unshift(sum);
	}
	if(carry > 0)
		result.unshift(carry);
	return result.join(''); 
};

var a = "11", b = "1";
var result = addBinary(a ,b);
console.log(a , " + " , b , " = " , result);

a = "000", b = "0";
result = addBinary(a ,b);
console.log(a , " + " , b , " = " , result);

a = "1000", b = "1";
result = addBinary(a ,b);
console.log(a , " + " , b , " = " , result);

a = "11101", b = "1";
result = addBinary(a ,b);
console.log(a , " + " , b , " = " , result);