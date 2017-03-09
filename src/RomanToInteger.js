/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    var table = {"I" : 1 , "V": 5 , "X": 10, "L": 50 , "C": 100 , "D" : 500 , "M": 1000};
    var intValue = 0 , prevNum = 0;
    for(var i = s.length - 1 ; i >= 0 ; i--){
    	var temp = table[s.charAt(i)];
    	if(prevNum > temp){
    		intValue -= temp;
    	}else{
    		intValue+=temp;
    	}
    	prevNum = temp;
    }
    return intValue;
};


var INPUT = "VIII";
var result = romanToInt(INPUT);
console.log(result);

var INPUT2 = "IV";
var result2 = romanToInt(INPUT2);
console.log(result2);