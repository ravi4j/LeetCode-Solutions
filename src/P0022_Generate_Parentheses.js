/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var result = [] , str = "";
    generate(result , str , n , n);
    return result;
};

var generate = function(result , str , left , right){

	if(left > right) return;

	if(left === 0  && right === 0){
		result.push(str);
		return;
	}

	if(left > 0) {
		generate(result , str + "(" , left - 1 ,right);
	}

	if(right > 0){
		generate(result , str + ")" , left ,right - 1);	
	}
};

var INPUT  = 3;
var result = generateParenthesis(INPUT);
for(var i = 0 ; i < result.length ; i++)
	console.log(result[i]);