/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {
    var dp = new Array(n + 1);
    dp.fill(0, 0, n + 1);
    dp[0] = 1;
    dp[1] = 1;
    for (let i = 2; i <= n; i++) {
        for (let j = 0; j < i; j++) {
            dp[i] = dp[i] + (dp[j] * dp[i - j - 1])
        }
    }
    return dp[n];
};

var n = 0;
var result = numTrees(n);
console.log(result);

n = 1;
result = numTrees(n);
console.log(result);

n = 2;
result = numTrees(n);
console.log(result);

n = 3;
result = numTrees(n);
console.log(result);