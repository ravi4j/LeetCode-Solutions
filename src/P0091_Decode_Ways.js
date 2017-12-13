/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if (s === null || s.length === 0) {
        return 0;
    }
    var n = s.length;
    var dp = new Array(n + 1);
    dp.fill(0, 0, n + 1);
    dp[0] = 1;
    dp[1] = s.charAt(0) !== '0' ? 1 : 0;
    for (let i = 2; i <= n; i++) {
        let first = parseInt(s.substring(i - 1, i));
        let second = parseInt(s.substring(i - 2, i));
        console.log(first, second);
        if (first >= 1 && first <= 9) {
            dp[i] += dp[i - 1];
        }
        if (second >= 10 && second <= 26) {
            dp[i] += dp[i - 2];
        }
    }
    return dp[n];
};

let s = "1234";
let result = numDecodings(s);
console.log(result);