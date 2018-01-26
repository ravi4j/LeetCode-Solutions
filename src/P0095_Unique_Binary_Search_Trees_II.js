/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var generateTrees = function(n) {
    if (n === 0) {
        return [];
    }
    return generateTreesHelper(1, n);
};

var generateTreesHelper = function(m, n) {
    var results = [];
    if (m > n) {
        results.push(null);
        return results;
    }

    for (var i = m; i <= n; i++) {
        var ls = generateTreesHelper(m, i - 1);
        var rs = generateTreesHelper(i + 1, n);
        for (var j = 0; j < ls.length; j++) {
            for (var k = 0; k < rs.length; k++) {
                var current = new TreeNode(i);
                current.left = ls[j];
                current.right = rs[k];
                results.push(current);
            }
        }
    }
    return results;
}

var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};

var printTree = function(root) {
    var h = height(root);
    var result = [];
    for (var i = 1; i <= h; i++) {
        printTreeLevelHelper(root, i, result);
    }
    console.log(result);
};

var printTreeLevelHelper = function(root, level, result) {
    if (root === null) {
        if (level == 1) {
            result.push(null);
        }
        return;
    }
    if (level === 1) {
        result.push(root.val);
    } else {
        printTreeLevelHelper(root.left, level - 1, result);
        printTreeLevelHelper(root.right, level - 1, result);
    }
};

var height = function(root) {
    if (root === null)
        return 0;
    else {
        var lh = height(root.left);
        var rh = height(root.right);
        if (lh > rh) {
            return lh + 1;
        } else {
            return rh + 1;
        }
    }
};

var n = 3;
var list = generateTrees(n);
list.forEach(root => {
    printTree(root);
    console.log();
});