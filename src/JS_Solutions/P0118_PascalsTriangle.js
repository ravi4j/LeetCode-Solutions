/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    var results = [];
    for (var i = 0; i < numRows; i++) {
        results[i] = [];
        for (var j = 0; j < i + 1; j++) {
            if (j === 0 || j === i) {
                results[i][j] = 1;
            } else {
                results[i][j] = results[i - 1][j - 1] + results[i - 1][j];
            }
        }
    }
    return results;
};

var numRows = 5;
var results = generate(numRows);
console.log("[ ");
for (var i = 0; i < results.length; i++) {
    console.log(results[i]);
}
console.log(" ]");