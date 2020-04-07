/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    transpose(matrix);
    reverseRow(matrix);
};

var anti_rotate = function(matrix) {
    transpose(matrix);
    reverseCol(matrix);
};		

var transpose = function(matrix){
	 var n = matrix.length , m = matrix[0].length;
	 var temp;
	for(var i = 0 ; i < n ; i++){
		for(var j =0 ; j < i ; j++){
			temp = matrix[i][j] ;
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}
};

var reverseRow = function(matrix){
	 var n = matrix.length , m = matrix[0].length;
	 var temp;
	for(var i = 0 ; i < n  ; i++){
		for(var j =0 ; j < m / 2; j++){
			temp = matrix[i][n - j - 1] ;
			matrix[i][n - j - 1] = matrix[i][j];
			matrix[i][j] = temp;
		}
	}

};


var reverseCol = function(matrix){
	 var n = matrix.length , m = matrix[0].length;
	 var temp;
	for(var i = 0 ; i < n / 2  ; i++){
		for(var j =0 ; j < m ; j++){
			temp = matrix[n - i  - 1][j] ;
			matrix[n - i  - 1][j] = matrix[i][j];
			matrix[i][j] = temp;
		}
	}
};

var displayMatrix = function(matrix){
	for(var i = 0 ; i < matrix.length ; i++){
		console.log(matrix[i]);
	}
};

var matrix = [];
var idx = 1 ;
for(var i = 0 ; i < 3 ; i++){
	matrix[i] = [];
	for(var j =0 ; j < 3 ; j++){
		matrix[i][j] = idx++;
	}
}
displayMatrix(matrix);
console.log("Rotate clock wise");
rotate(matrix);
displayMatrix(matrix);
console.log("Rotate anit clock wise to get orginal matrix");
anti_rotate(matrix);
displayMatrix(matrix);

