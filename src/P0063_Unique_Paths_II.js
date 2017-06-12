/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    
    if(obstacleGrid === null || obstacleGrid.length === 0)
    	return 0;

 	var matrix = [];
    var m = obstacleGrid.length , n = obstacleGrid[0].length;
    for(var i = 0 ; i < m ; i++){
    	matrix[i] = [];
    	for(var j = 0; j < n ; j++){
    		if(i === 0 && j === 0){
    			if(obstacleGrid[i][j] !== 1)
    				matrix[i][j] = 1;
    			else
    				matrix[i][j] = 0;

    		} else if( i === 0 && j !== 0){
    			if(obstacleGrid[i][j] !== 1)
    				matrix[i][j] = matrix[i][j - 1];
    			else
    				matrix[i][j] = 0;
    		} else if (i !== 0 && j === 0){
    			if(obstacleGrid[i][j] !== 1)
    			 	matrix[i][j] = matrix[i - 1][j];
    			 else
    			 	matrix[i][j] = 0;
    		}else {
    			if(obstacleGrid[i][j] !== 1)
    				matrix[i][j] = matrix[i-1][j] + matrix[i][j -1];
    			else
    				matrix[i][j] = 0;
    		}

    	}
    }
    return matrix[m - 1][n -1];
};

var obstacleGrid = [
		[0,0,0] , [0,1,0] , [0,0,0]
];

var path = uniquePathsWithObstacles(obstacleGrid);
console.log(path); 
