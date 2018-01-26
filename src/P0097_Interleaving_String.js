/**
 * @param {string} s1
 * @param {string} s2
 * @param {string} s3
 * @return {boolean}
 */
var isInterleave = function(s1, s2, s3) {
    if (s1.length + s2.length !== s3.length)
        return false;
    var inValid = new Array(s1.length + 1);
    for (let i = 0; i <= s1.length; i++) {
        inValid[i] = new Array(s2.length + 1);
        inValid[i].fill(false);
    }
    console.log(inValid);
    return dfs(s1, s2, s3, 0, 0, 0, inValid);
};

var dfs = function(c1, c2, c3, i, j, k, inValid) {
    if (inValid[i][j])
        return false;
    if (k === c3.length)
        return true;

    var valid = (i < c1.length && c1.charAt(i) === c3.charAt(k) && dfs(c1, c2, c3, i + 1, j, k + 1, inValid)) ||
        (j < c2.length && c2.charAt(j) === c3.charAt(k) && dfs(c1, c2, c3, i, j + 1, k + 1, inValid));
    if (!valid)
        inValid[i][j] = true;
    return valid;
};


var s1 = "aabcc",
    s2 = "dbbca";
//When s3 = "aadbbcbcac", return true.
var s3 = "aadbbcbcac";
//console.log(isInterleave(s1, s2, s3));

//When s3 = "aadbbbaccc", return false.
s3 = "aadbbbaccc";
//console.log(isInterleave(s1, s2, s3));

// Should return true
s1 = "aa", s2 = "ab", s3 = "aaba";
console.log(isInterleave(s1, s2, s3));