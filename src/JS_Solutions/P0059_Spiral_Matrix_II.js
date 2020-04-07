/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function(n) {
	if (n === null || n === 0)
		return [];

	var i = 0,
		k = 0,
		l = 0,
		start = 1,
		m = n;
	var matrix = [];
	
	for( var j = 0 ; j < n ; j++)
		matrix[j] = [];

	while (k < m && l < n) {

		//print left->right
		for (i = l; i < n; i++) {
			matrix[k][i] = start++;
		}
		k++;
		//print top->down
		for (i = k; i < m ; i++) {
			matrix[i][n - 1] = start++;
		}
		n--;
		//print right->left	
		if (k < m) {
			for (i = n - 1; i >= l; i--) {
				matrix[m - 1][i] = start++;
			}
			m--;
		}
		// print bottom -> up	
		if (l < n) {
			for (i = m - 1; i >= k; i--) {
				matrix[i][l] = start++;
			}
			l++;
		}
	}
	return matrix;
};


var printMatrix = function(matrix) {
	for (var i = 0; i < matrix.length; i++) {
		console.log(matrix[i]);
	}
};

var result = generateMatrix(3);
printMatrix(result);
