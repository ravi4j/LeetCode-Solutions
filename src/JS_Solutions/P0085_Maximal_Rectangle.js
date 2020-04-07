/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {

    if (matrix === null || matrix.length === 0)
        return 0;

    let m = matrix.length,
        n = matrix[0].length,
        maxA = 0;
    let height = [],
        left = [],
        right = [];
    fillArray(height, n, 0);
    fillArray(left, n, 0);
    fillArray(right, n, n);
    for (let i = 0; i < m; i++) {
        let curr_l = 0,
            curr_r = n;
        // calculate height
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === '1')
                height[j] += 1;
            else
                height[j] = 0;
        }

        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === '1')
                left[j] = Math.max(left[j], curr_l);
            else {
                left[j] = 0;
                curr_l = j + 1;
            }
        }

        for (let j = n - 1; j >= 0; j--) {
            if (matrix[i][j] === '1')
                right[j] = Math.min(right[j], curr_r);
            else {
                right[j] = n;
                curr_r = j;
            }
        }

        for (let j = 0; j < n; j++) {
            maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
        }

    }
    return maxA;
};

var fillArray = function(array, size, value) {
    for (let i = 0; i < size; i++) {
        array[i] = value;
    }
}

let matrix = [
    ['1', '0', '1', '0', '0'],
    ['1', '0', '1', '1', '1'],
    ['1', '1', '1', '1', '1'],
    ['1', '0', '0', '1', '0'],
];


let result = maximalRectangle(matrix);
console.log(result);