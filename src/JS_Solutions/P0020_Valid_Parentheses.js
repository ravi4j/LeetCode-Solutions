/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
	
	if(s === null || s.length === 0) return false;

	var OPENING = "({[" , CLOSING = ")}]" , stack =[];
	for(var i = 0 ; i < s.length ; i++){
		var ch = s.charAt(i);
		if(OPENING.indexOf(ch) !== -1){
			stack.push(ch);
		}
		else if(CLOSING.indexOf(ch) !== -1){
			if(stack.length === 0) return false;
			var indexOf_closing = CLOSING.indexOf(ch);
			if(stack[stack.length - 1] === OPENING.charAt(indexOf_closing))
				stack.pop();
			else
				return false;
		} else{
			return false;
		}
	}

    return stack.length === 0 ? true : false;
};


var INPUT_VALID = "()[]{}";
console.log(INPUT_VALID + " : " + isValid(INPUT_VALID));

INPUT_VALID = "()";
console.log(INPUT_VALID + " : " + isValid(INPUT_VALID));

var INPUT_INVALID = "([)]";
console.log(INPUT_INVALID + " : " + isValid(INPUT_INVALID));

INPUT_INVALID = "(]";
console.log(INPUT_INVALID + " : " + isValid(INPUT_INVALID));
