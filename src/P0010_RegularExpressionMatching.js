/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {

};


console.log("isMatch('aa','a')  → " + isMatch("aa","a")); // → false
console.log("isMatch('aa','aa') → " + isMatch("aa","aa")); // → true
console.log("isMatch('aaa','aa') → " + isMatch("aaa","aa")); // → false
console.log("isMatch('aa','a*')  → " + isMatch("aa", "a*")); // → true
console.log("isMatch('aa','.*')  → " + isMatch("aa", ".*")); // → true
console.log("isMatch('ab','.*')  → " + isMatch("ab", ".*")); // → true
console.log("isMatch('aa','c*a*b')  → " + isMatch("aab", "c*a*b")); // → true