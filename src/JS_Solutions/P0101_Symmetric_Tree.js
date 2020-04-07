/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    return root === null || isSymmetricHelper(root.left, root.right);
};

var isSymmetricHelper = function(left, right) {
    if (left === null || right === null) {
        return left === right;
    }
    if (left.val !== right.val) {
        return false;
    }
    return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
};

var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};

var sTree = new TreeNode(1);
sTree.left = new TreeNode(2);
sTree.right = new TreeNode(2);
sTree.left.left = new TreeNode(3);
sTree.left.right = new TreeNode(4);
sTree.right.left = new TreeNode(4);
sTree.right.right = new TreeNode(3);
console.log(isSymmetric(sTree));

var aTree = new TreeNode(1);
aTree.left = new TreeNode(2);
aTree.right = new TreeNode(2);
aTree.left.right = new TreeNode(3);
aTree.right.right = new TreeNode(3);
console.log(isSymmetric(aTree));