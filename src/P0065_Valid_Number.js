/**
 * @param {string} s
 * @return {boolean}
 */

var SPACE = 0 , SIGN = 1 , DIGIT = 2 , DOT = 3 , EXP = 4 , NULL = -1;
var FSM = [
			[0  , 8 , -1 , -1 ,  8 , -1 , -1 ,  8 ,  8],
			[2  ,-1 , -1 , -1 , -1 ,  6 , -1 , -1 , -1],
			[1  , 1 ,  1 ,  4 ,  4 ,  7 ,  7 ,  7 , -1],
			[3  , 4 ,  3 ,  -1 , -1 , -1 , -1 , -1 , -1],
			[-1 , 5 , -1 , -1 ,  5 , -1 , -1 , -1 , -1]
		  ];
var isNumber = function(s) {
	var state = 0 , ch, inputType = NULL;
	for(var i = 0 ; i < s.length ; i++){
		ch = s.charAt(i);
		if(ch === ' '){
			inputType = SPACE;
		} else if(ch === '+' || ch === '-'){
			inputType = SIGN;
		} else if(ch >= '0' && ch <= '9'){
			inputType = DIGIT;
		} else if(ch === '.'){
			inputType = DOT;
		} else if(ch === 'e' || ch === 'E'){
			inputType = EXP
		} else {
			return false;
		}
		console.log(inputType , state);	
		state = FSM[inputType][state];
		console.log('->' , state);
		if( state < 0){
			return false;
		}
	}
	return ( state === 1 || state === 4 || state === 7 || state === 8);    
};

//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
var number = "0..";
console.log(number , ' is number ' , isNumber(number));

// number = " 0.1";
// console.log(number , ' is number ' , isNumber(number));

// number = "abc";
// console.log(number , ' is number ' , isNumber(number));

// number = "1 a";
// console.log(number , ' is number ' , isNumber(number));

// number = "2e10";
// console.log(number , ' is number ' , isNumber(number));

// number = "-2e-10";
// console.log(number , ' is number ' , isNumber(number));

// number = "0..";
// console.log(number , ' is number ' , isNumber(number));




