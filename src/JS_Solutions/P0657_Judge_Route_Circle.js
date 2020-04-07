/**
 * @param {string} moves
 * @return {boolean}
 */
var judgeCircle = function(moves) {
    if (moves === null || moves === '')
        return true;
    let x = 0,
        y = 0;
    let dir = { "L": [-1, 0], "U": [0, -1], "D": [0, 1], "R": [1, 0] };
    for (let i = 0; i < moves.length; i++) {
        let ch = moves.charAt(i);
        let move = dir[ch];
        x = x + move[0];
        y = y + move[1];
    }
    return (x === 0 && y === 0) ? true : false;
};

var moves = "UD";
var result = judgeCircle(moves);
console.log(result);

moves = "LL";
result = judgeCircle(moves);
console.log(result);