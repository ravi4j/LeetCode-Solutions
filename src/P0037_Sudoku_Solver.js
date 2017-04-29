/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function(board) {
  return solveSudokuPartial(board , 0 , 0);  
};

var solveSudokuPartial = function(board , i , j){
	if(i === board.length){
		i = 0;
		if(++j === board[i].length){
			return true; // entire board is solved
		}
	}

	if(board[i][j] !== '.'){
		return solveSudokuPartial(board , i + 1 , j);
	}
	
	for(var val = 1 ; val <= board.length ; val++){
		if(isValidEntry(board , i, j , val)){
			board[i][j] = val;
			if(solveSudokuPartial(board , i + 1 , j )){
				return true;
			}
		}
	}

	board[i][j] = '.';
	return false;
};

var isValidEntry = function(board , r , c , val){
	var rsize = board.length , csize = board[0].length;
	// check column data
	for(var i = 0 ; i < rsize ; i++){
		if(parseInt(board[i][c]) === val)
			return false;
	}
	// check column data
	for(var j = 0 ; j < csize ; j++){
		if(parseInt(board[r][j]) === val)
			return false;
	}
	
	var regionsize = parseInt(Math.sqrt(rsize));
	var I = parseInt(r / regionsize) , J = parseInt(c / regionsize);
	var idx = 0, jdx = 0; 
	for(i = 0 ; i < regionsize ; i++){
		for(j = 0 ; j < regionsize ; j++){
			idx = parseInt(regionsize * I + i);
			jdx = parseInt(regionsize * J + j);
			if(parseInt(board[idx][jdx]) === val)
				return false;
		}
	}

	return true;
};

var str_board = ["53..7....",
			 "6..195...",
			 ".98....6.",
			 "8...6...3",	
			 "4..8.3..1",
			 "7...2...6",
			 ".6....28.",
			 "...419..5",
			 "....8..79"
			];

var board = function(str_board){
	var board_array = [];
	var str_board_size = str_board.length;
	for(var i = 0 ; i < str_board_size ; i++){
		var row = str_board[i].split('');
		board_array[i] = row;
	}
	return board_array;
};
//console.log(str_board);
var b = board(str_board);
var validEntry = solveSudoku(b);
console.log(validEntry);
console.log(b);