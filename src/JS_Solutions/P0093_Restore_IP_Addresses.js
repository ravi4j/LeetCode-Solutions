/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    var solutions = [];
    restoreIP(s, solutions, 0, "", 0);
    return solutions;
};

var restoreIP = function(ip, solutions, idx, restoreStr, count) {

    if (count > 4) return;
    // console.log(restoreStr, count, idx, ip.length);
    if (count === 4 && idx === ip.length) {
        solutions.push(restoreStr);
    }

    for (var i = 1; i < 4; i++) {
        if (idx + i > ip.length) break;
        var s = ip.substring(idx, idx + i);
        if ((s.startsWith("0") && s.length > 1) || (i === 3 && parseInt(s) >= 256))
            continue;
        if (count === 3) {
            restoreIP(ip, solutions, idx + i, restoreStr + s, count + 1);
        } else {
            restoreIP(ip, solutions, idx + i, restoreStr + s + ".", count + 1);
        }

    }

}

var s = "25525511135";

var results = restoreIpAddresses(s);
console.log(results);