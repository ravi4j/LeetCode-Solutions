/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
	var results = [];
	nQueens(n , 0 , [] , results);
	for(var i = 0 ; i < results.length ; i++){
		results[i] = createBoard( n , results[i]);
	}    
	return results;
};

var nQueens = function(n , row , colPlacement , results){
	if(row === n) {
		results.push([].concat(colPlacement));
	} else{
		for(var col = 0 ; col < n ; col++){
			colPlacement.push(col);
			if(isValid(colPlacement)){
				nQueens(n , row + 1 , colPlacement , results);
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

var createBoard = function( n , colPlacement){
	var board = [];
	for(var i = 0; i < n ; i++){
		var row = [];
		for(var j = 0; j < n ; j++){
			if(colPlacement[i] === j)
				row[j] = 'Q';
			else
				row[j] = '.';
		}
		board[i] = row.join('');
	}
	return board;
};

var printBoard = function(board){
	console.log(board);
};

var n = 4;
var results = solveNQueens(n);
printBoard(results);