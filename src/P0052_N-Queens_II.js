/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
	var count = [];
	nQueens(n , 0 , [] , count);
	return count.length ;
};

var nQueens = function(n , row , colPlacement , count){
	if(row === n) {
		 count.push(1);
	} else{
		for(var col = 0 ; col < n ; col++){
			colPlacement.push(col);
			if(isValid(colPlacement)){
				nQueens(n , row + 1 , colPlacement , count);
			}
			colPlacement.pop();
		}
	}
};

var isValid = function(colPlacement){
 var rowId = colPlacement.length - 1;
 for(var i = 0 ; i < rowId ; i++){
 	var diff = Math.abs(colPlacement[i] - colPlacement[rowId]);
 	if( diff === 0  || diff === rowId -i)
 		return false;
 }	
 return true;	
};

var n = 4;
var result = solveNQueens(n);
console.log(result)