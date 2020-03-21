/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    var matrix = [];

    for(var i = 0 ; i < m ; i++){
    	matrix[i] = [];
    	for(var j = 0; j < n ; j++){
    		if(i === 0 && j === 0){
    			matrix[i][j] = 1;
    		} else if( i === 0 && j !== 0){
    			matrix[i][j] = matrix[i][j - 1];
    		} else if (i !== 0 && j === 0){
    			matrix[i][j] = matrix[i - 1][j];
    		}else {
    			matrix[i][j] = matrix[i-1][j] + matrix[i][j -1];
    		}

    	}
    }
    return matrix[m - 1][n -1];
};

var m = 3 , n = 3;
var path = uniquePaths(m , n);
console.log(path); 