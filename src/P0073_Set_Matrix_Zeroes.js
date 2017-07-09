/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
  if(matrix === null || matrix.length === 0 || matrix[0].length === 0)
    return;

  let m = matrix.length , n = matrix[0].length , frow = false, fcol = false;
  
   // check first row
  for(let j = 0 ; j < n ; j++){
      if(matrix[0][j] === 0){
        frow = true;
      }
  } 
  
  // check first col
  for(let i = 0 ; i < m ; i++){
      if(matrix[i][0] === 0){
        fcol = true;
      }
  } 


  for(let i = 1 ; i < m; i++){
      for(let j = 1 ; j < n ; j++){
          if(matrix[i][j] === 0){
              matrix[i][0] = 0;
              matrix[0][j] = 0;
          }
      }
  }

  for(let j = 1 ; j < n ; j++ ){
      if(matrix[0][j] === 0){
          for(let i = 1 ; i < m ; i++){
              matrix[i][j] = 0;
          }
      }
  }

  for(let i = 1 ; i < m ; i++ ){
      if(matrix[i][0] === 0){
          for(let j = 1 ; j < n ; j++){
              matrix[i][j] = 0;
          }
      }
  }

  if(frow === true){
    for(let j = 0 ; j <  n ; j++){
        matrix[0][j] = 0;
    }
  }

  if(fcol === true){
    for(let i = 0 ; i < m ; i++){
        matrix[i][0] = 0;
    }
  }   
};


var createMatrix = function(m , n){
    let matrix = [];
    for( let i = 0 ; i < m ; i++){
        matrix[i] = [];
        for(let j = 0 ; j < n ; j++){
            matrix[i][j] = parseInt(Math.random() * 10);
        }
    }
    return matrix;
};

var printMatrix = function(matrix){
    for(let i = 0 ; i < matrix.length ; i++){
        console.log(matrix[i]);
    }
};

let testCase = 1;
console.log("Test Case " , testCase++);
let matrix = createMatrix(3,3);
console.log("Input matrix");
printMatrix(matrix);
setZeroes(matrix);
console.log("Resultant matrix");
printMatrix(matrix);

console.log("Test Case " , testCase++);
matrix = createMatrix(5,4);
console.log("Input matrix");
printMatrix(matrix);
setZeroes(matrix);
console.log("Resultant matrix");
printMatrix(matrix);