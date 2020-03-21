/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var isScramble = function(s1, s2) {
    if (s1 === null || s2 === null || s1.length !== s2.length)
        return false;
    if (s1.length === 0)
        return true;
    let len = s1.length;
    let dp = [];
    for (let i = 0; i < len; i++) {
        dp[i] = [];
        for (let j = 0; j < len; j++) {
            dp[i][j] = Array(len).fill(false);
            if (s1.charAt(i) === s2.charAt(j)) {
                dp[i][j][0] = true;
            }
        }
    }
    for (let m = 1; m < len; m++) {
        for (let i = 0; i < len - m; i++) {
            for (let j = 0; j < len - m; j++) {
                for (let k = 0; k < m; k++) {
                    if ((dp[i][j][k] && dp[i + k + 1][j + k + 1][m - k - 1]) || (dp[i][j + m - k][k] && dp[i + k + 1][j][m - k - 1])) {
                        dp[i][j][m] = true;
                    }
                }
            }
        }
    }
    return dp[0][0][len - 1];
};

var printDP = function(dp) {
    var len = dp[0].length;
    for (let i = 0; i < len; i++) {
        {
            console.log(dp[i]);
        }
    }
};

var s1 = "great",
    s2 = "rgtae";
var result = isScramble(s1, s2);
//printDP(result);
console.log(result);