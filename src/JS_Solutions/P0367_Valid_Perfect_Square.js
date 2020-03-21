/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    if (num < 1) 
        return false;
    let left = 1, right = num;
      while (left <= right) {
        let mid = left + parseInt((right - left) / 2);
        let t = mid * mid;
        if (t > num) {
          right = mid - 1;
        } else if (t < num) {
          left = mid + 1;
        } else {
          return true;
        }
      }
    
      return false;
};

var x = 25;
var result = isPerfectSquare(x);
console.log(result);

var x = 9;
var result = isPerfectSquare(x);
console.log(result);

var x = 24;
var result = isPerfectSquare(x);
console.log(result); 