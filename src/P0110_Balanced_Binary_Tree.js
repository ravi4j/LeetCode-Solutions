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
var isBalanced = function(root) {
    return dfsHeight(root) !== -1;
};

var dfsHeight = function(root) {
    if (root === null)
        return 0;
    var l = dfsHeight(root.left);
    if (l === -1) return -1;
    var r = dfsHeight(root.right);
    if (r === -1) return -1;
    if (Math.abs(l - r) > 1) return -1;
    return 1 + Math.max(l, r);
};


function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
};

var balancedTree = new TreeNode(3);
balancedTree.left = new TreeNode(9);
balancedTree.right = new TreeNode(20);
balancedTree.right.left = new TreeNode(15);
balancedTree.right.right = new TreeNode(7);

console.log(isBalanced(balancedTree));

var notBalanceTree = new TreeNode(1);
notBalanceTree.left = new TreeNode(2);
notBalanceTree.right = new TreeNode(2);
notBalanceTree.left.left = new TreeNode(3);
notBalanceTree.left.right = new TreeNode(3);
notBalanceTree.left.left.left = new TreeNode(4);
notBalanceTree.left.left.right = new TreeNode(4);

console.log(isBalanced(notBalanceTree));