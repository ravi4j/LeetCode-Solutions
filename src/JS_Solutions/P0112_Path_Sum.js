/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */
var hasPathSum = function(root, sum) {
    if (root === null)
        return false;

    if (root.left === null && root.right === null)
        return sum === root.val;

    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
};

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
};

var root = new TreeNode(5);
root.left = new TreeNode(4);
root.right = new TreeNode(8);
root.left.left = new TreeNode(11);
root.left.left.left = new TreeNode(7);
root.left.left.right = new TreeNode(2);
root.right.left = new TreeNode(13);
root.right.right = new TreeNode(4);
root.right.right.right = new TreeNode(1);

var sum = 22;

console.log(hasPathSum(root, sum));