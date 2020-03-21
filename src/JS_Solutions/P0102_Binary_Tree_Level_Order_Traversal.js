/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    var h = height(root);
    var result = [];
    for (var i = 0; i < h; i++) {
        var row = []
        levelOrderHelper(root, i, row);
        result[i] = row;
    }
    return result;
};

var levelOrderHelper = function(root, level, row) {
    if (root === null) {
        return;
    }
    if (level === 0) {
        row.push(root.val);
    } else {
        levelOrderHelper(root.left, level - 1, row);
        levelOrderHelper(root.right, level - 1, row);
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

var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};

var root = new TreeNode(3);
root.left = new TreeNode(9);
root.right = new TreeNode(20);
root.right.left = new TreeNode(15);
root.right.right = new TreeNode(7);

var result = levelOrder(root);
console.log(result);