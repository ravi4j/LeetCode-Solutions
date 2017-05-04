/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
	var n = num1.length , m = num2.length;
	var pos = [] , p0 = 0 , p1 = 0;
	var sum = 0 , mul = 0;
	for(var k = 0 ; k < m + n ; k++)
		pos[k] = 0;
	for(var i = n - 1 ; i >=0 ; i--){
		for(var j = m -1 ; j >= 0; j--){
			mul = parseInt(num1.charAt(i)) * parseInt(num2.charAt(j));
			p0 = i + j;
			p1 = i + j + 1;
			sum = mul + pos[p1];
			pos[p0] += parseInt(sum / 10);
			pos[p1] = parseInt(sum % 10);
		}
	}
	var result = '';
	for(k = 0  ; k < m + n ; k++){
		if( !(result.length === 0 && pos[k] === 0)){
			result += pos[k];
		}
	}
	return result.length === 0 ? '0' : result;
};

var num1 = '120' , num2 = '100';
var result = multiply(num1 , num2);
console.log(result);