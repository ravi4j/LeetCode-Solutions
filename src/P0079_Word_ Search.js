/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    if(board === null || board.length === 0)
        return false;
   let result = false;
    for(let i = 0 ; i < board.length; i++){
        for(let j = 0 ; j < board[i].length ; j++){
            if(dsf(board , word , i , j , 0)){
                result = true;
            }
        }
    }
    return result;
};

var dsf = function(board , word , row , col , index){
    let m = board.length ; n = board[0].length;
    if( row < 0 || row >=m || col < 0 || col >= n ){
        return false;
    }
    if(word.charAt(index) === board[row][col] ){
        let tempChar =  board[row][col];
         board[row][col] = '#';
         if(index === word.length - 1)
            return true;
         else if(dsf(board , word , row - 1 , col , index + 1)
               ||  dsf(board , word , row + 1 , col , index + 1)
               ||  dsf(board , word , row  , col - 1 , index + 1)
               ||  dsf(board , word , row  , col + 1 , index + 1) 
            ){
                return true;
            } 
        board[row][col] = tempChar;    
       }    
    return false;
};

let board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
];
let word1 = 'ABCCED' , word2 = 'SEE' , word3 = 'ABCB';
console.log("Is exist ?"  , exist(board , word1));
board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
];
console.log("Is exist ?"  , exist(board , word2));
board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
];
console.log("Is exist ?"  , exist(board , word3));