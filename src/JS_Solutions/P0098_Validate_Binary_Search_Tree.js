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
var isValidBST = function(root) {
    return isValid(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
};

var isValid = function(root, min, max) {
    if (root === null) return true;
    if (root.val >= max || root.val <= min) return false;
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
};

var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};


var tree1 = new TreeNode(2);
tree1.left = new TreeNode(1);;
tree1.right = new TreeNode(3);
console.log(isValidBST(tree1));

var tree2 = new TreeNode(1);
tree2.left = new TreeNode(2);;
tree2.right = new TreeNode(3);
console.log(isValidBST(tree2));

var tree3 = new TreeNode(0);
console.log(isValidBST(tree3));