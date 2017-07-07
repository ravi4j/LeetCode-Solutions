/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
	for( var i = digits.length - 1 ; i >= 0 ; i--){
		if(digits[i] < 9){
			digits[i] +=1;
			return digits;
		} else {
			digits[i] = 0;
		}
	}
    digits.unshift(1);
    return digits;
};


var digits = [9,9];
var result = plusOne(digits);
console.log(result);

digits = [9,8];
result = plusOne(digits);
console.log(result);

digits = [8,9 ,9,9, 9];
result = plusOne(digits);
console.log(result);

digits = [1,0,1];
result = plusOne(digits);
console.log(result);
