/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
	if(s === null || s.length === 0)
		return 0;
    var sArrray = s.trim().split(' ');
    return sArrray[sArrray.length - 1].length;
};

var s = "Hello World";
var result = lengthOfLastWord(s);
console.log(result);

var s = "Hello World aadsd ds dd sds ds dsd sds dsd s dsddddddddddddd";
var result = lengthOfLastWord(s);
console.log(result);

var s = 'a ';
var result = lengthOfLastWord(s);
console.log(result);

var s = null;
var result = lengthOfLastWord(s);
console.log(result);