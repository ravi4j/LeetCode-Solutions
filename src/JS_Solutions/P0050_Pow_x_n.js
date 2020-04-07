/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
	var temp = x;
	if(n === 0)
		return 1;
	temp = myPow(x , parseInt(n/2));
	if ( n % 2 === 0) {
		return temp * temp;
	} else {
		if(n > 0){
			return x * temp * temp;
		} else {
			return (temp * temp) / x;
		}
	}
    
};

var x = 3 , n = -1;
var result = myPow(x,n);
console.log(result);