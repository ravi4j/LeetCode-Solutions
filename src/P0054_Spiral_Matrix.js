/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
	if (matrix === null)
		return null;
	if (matrix.length === 0)
		return [];

	var i = 0,
		k = 0,
		l = 0,
		m = matrix.length,
		n = matrix[0].length;
	var result = [];
	while (k < m && l < n) {

		//print left->right
		for (i = l; i < n; i++) {
			result.push(matrix[k][i]);
		}
		k++;
		//print top->down
		for (i = k; i < m ; i++) {
			result.push(matrix[i][n - 1]);
		}
		n--;
		//print right->left	
		if (k < m) {
			for (i = n - 1; i >= l; i--) {
				result.push(matrix[m - 1][i]);
			}
			m--;
		}
		// print bottom -> up	
		if (l < n) {
			for (i = m - 1; i >= k; i--) {
				result.push(matrix[i][l]);
			}
			l++;
		}
	}
	return result;
};

var createMatrix = function(m , n) {
	var matrix = [],
		start = 1;
	for (var i = 0; i < m; i++) {
		matrix[i] = [];
		for (var j = 0; j < n; j++) {
			matrix[i][j] = start++;
		}
	}
	return matrix;
};

var printMatrix = function(matrix) {
	for (var i = 0; i < matrix.length; i++) {
		console.log(matrix[i]);
	}
};

var matrix = createMatrix(3 , 3);
printMatrix(matrix);
var result = spiralOrder(matrix);
console.log(result + '\n');

matrix = createMatrix(4 , 4);
printMatrix(matrix);
result = spiralOrder(matrix);
console.log(result);

matrix = createMatrix(1 , 2);
printMatrix(matrix);
result = spiralOrder(matrix);
console.log(result);