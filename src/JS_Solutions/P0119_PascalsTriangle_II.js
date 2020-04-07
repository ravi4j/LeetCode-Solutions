/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
    var row = new Array(rowIndex + 1);
    row.fill(0);
    row[0] = 1;
    for (var i = 1; i < rowIndex + 1; i++) {
        for (var j = i; j > 0; j--) {
            row[j] += row[j - 1];
        }
    }
    return row;
};

var rowIndex = 2;
var row = getRow(rowIndex);
console.log(rowIndex);