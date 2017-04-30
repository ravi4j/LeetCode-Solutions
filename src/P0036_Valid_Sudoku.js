/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
	//check rows
	 if(board.length === 0) 
	 		return false;
	
	var hasDup = false;	
	for( var r = 0 ; r < 9 ; r++){
       hasDup = hasDuplicate(board , r , r + 1 , 0 , 9);
       if(hasDup)
       	 return false;
	}	

	//check cols
	for( var c = 0 ; c < 9 ; c++){
       hasDup = hasDuplicate(board , 0 , 9 , c , c + 1);
       if(hasDup)
       	 return false;
	} 

	for(r = 0 ; r < 9 ; r = r + 3){
		for(c = 0 ; c < 9 ; c = c + 3){
		   hasDup = hasDuplicate(board , r , r + 3  , c , c + 3);
		   if(hasDup)
		    	return false;
		}
	}
    
    return true;
};

var hasDuplicate = function(board , rStart , rEnd ,cStart , cEnd) {
   var flags = [0 , 0, 0 ,0 , 0, 0, 0, 0 , 0 , 0];
   var result = [];
   for(var i = rStart; i < rEnd ; i++){
   		for(var j = cStart ; j < cEnd ; j++){
   			var d = board[i][j] !== '.' ? parseInt(board[i][j]) : 0;
   			result.push(d);
   			if( d !== 0){
   			  if(flags[d] === 1)
   			 	 return true;
   			 else
   				 flags[d] = 1;
   			}
   		}
   }
    //console.log(" [ " + result.join(" , ") + " ]");
   	return false;
};

/*var board = [["5", "3", "." , "." , "7" , "." , "." , "." , "."],
			 ["6", ".", "." , "1" , "9" , "5" , "." , "." , "."],
			 [".", "9", "8" , "." , "." , "." , "." , "6" , "."],
			 ["8", ".", "." , "." , "6" , "." , "." , "." , "3"],
			 ["4", ".", "." , "8" , "." , "3" , "." , "." , "1"],
			 ["7", ".", "." , "." , "2" , "." , "." , "." , "6"],
			 [".", "6", "." , "." , "." , "." , "2" , "8" , "."],
			 [".", ".", "." , "4" , "1" , "9" , "." , "." , "5"],
			 [".", ".", "." , "." , "8" , "." , "." , "." , "9"],
			 ];
*/
var board  = [".87654321","2........","3........","4........","5........","6........","7........","8........","9........"];


/*var validColumn = hasDuplicate(board , 0 , 1 , 0, 9);
console.log(validColumn);

var validRow = hasDuplicate(board , 0 , 9 , 0, 1);
console.log(validRow);


var validRowColumn = hasDuplicate(board , 0 , 3 , 0, 3);
console.log(validRowColumn); */

var result = isValidSudoku(board);
console.log(result);

var board  = [".87654321","2........","3........","4........","5........","6........","7........","8........","9........"];
var result = isValidSudoku(board);
console.log(result);