/**
 * @param {string} digits
 * @return {string[]}
 */

var letterCombinations = function(digits) {
	
	if(digits === "") return[];

    var dict = ["_" , "" , "abc" ,  "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" ,"wxyz"];
    var combinations = [] , digits_so_far = digits.split("").map(Number) , path_so_far = "";
    var recursive = function(digits , path){
						if(digits.length === 0){
							combinations.push(path); 
							return;
						}
						var first = digits[0] , rest = digits.slice(1, digits.length) , letters = dict[first];
						for(var i = 0 ; i < letters.length ; i++){
							recursive(rest , path + letters.charAt(i))
						}
					}
    recursive(digits_so_far, path_so_far);
    return combinations;
};


//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

var INPUT = "";
var result = letterCombinations(INPUT);
console.log("[ " + result.join(" , ") + " ]");