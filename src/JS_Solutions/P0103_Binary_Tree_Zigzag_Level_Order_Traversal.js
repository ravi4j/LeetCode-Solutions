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
var zigzagLevelOrder = function(root) {
    var h = height(root);
    var result = [];
    var dir = false;
    for (var i = 1; i <= h; i++) {
        var row = []
        levelOrderHelper(root, i, row, dir);
        result[i - 1] = row;
        dir = !dir;
    }
    return result;
};

var levelOrderHelper = function(root, level, row, dir) {
    if (root === null) {
        return;
    }
    if (level === 1) {
        row.push(root.val);
    } else if (level > 1) {
        if (dir) {
            levelOrderHelper(root.right, level - 1, row, dir);
            levelOrderHelper(root.left, level - 1, row, dir);
        } else {
            levelOrderHelper(root.left, level - 1, row, dir);
            levelOrderHelper(root.right, level - 1, row, dir);
        }
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

var result = zigzagLevelOrder(root);
console.log(result);

root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(7);
result = zigzagLevelOrder(root);
console.log(result);