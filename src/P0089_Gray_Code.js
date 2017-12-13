/**
 * @param {number} n
 * @return {number[]}
 */
var grayCode = function(n) {
    var result = [];
    if (n === 0) {
        result.push(0);
        return result;
    }

    var lastCodes = grayCode(n - 1);
    var addOnNum = 1 << n - 1;
    result = result.concat(lastCodes);
    for (var i = lastCodes.length - 1; i >= 0; i--) {
        result.push(lastCodes[i] + addOnNum)
    }
    return result;
};

var n = 3;
var result = grayCode(n);
console.log(result);