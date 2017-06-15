/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
	if( grid === null || grid.length === 0)
		return 0;
	var m = grid.length , n = grid[0].length;
    for(var i = 0 ; i < m ; i++){
    	for(var j = 0; j < n ; j++){
    		if(i === 0 && j === 0){
    			grid[i][j] = grid[i][j];
    		} else if( i === 0 && j !== 0){
    			grid[i][j] = grid[i][j] + grid[i][j - 1];
    		} else if (i !== 0 && j === 0){
    			grid[i][j] = grid[i][j] + grid[i - 1][j];
    		}else {
    			grid[i][j] = grid[i][j] + Math.min(grid[i-1][j] ,  grid[i][j -1]);
    		}

    	}
    }
    return grid[m - 1][n -1];
};

var grid = [
		[1,2,3] , 
		[1,2,3] , 
		[1,1,1]
];
var result = minPathSum(grid);
console.log(result);