/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if(matrix === null || matrix.length === 0)
        return false;
    let m = matrix.length  , n = matrix[0].length;    
    let l = 0 , r =  (m * n) - 1;
    while(l <= r){
        let mid = ( l + r) >> 1;
        let i = parseInt(mid / n) , j = mid % n;
        if( matrix[i][j] < target){
            l = mid + 1;
        } else if ( matrix[i][j] > target) {
            r = mid - 1;
        } else {
            return true;
        }
    }    
   return false; 
};

let matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
];

let target = 3;
let result = searchMatrix(matrix , target);
console.log(result);

matrix = [[1,1]];
target = 2;
result = searchMatrix(matrix , target);
console.log(result);