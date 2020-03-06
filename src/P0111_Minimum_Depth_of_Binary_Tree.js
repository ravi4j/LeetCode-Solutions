/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function(root) {
    if (root === null)
        return 0;

    var l = minDepth(root.left);
    var r = minDepth(root.right);
    // console.log(" l = " + l + " , r = " + r);
    return (l === 0 || r === 0) ? l + r + 1 : Math.min(l, r) + 1;
};

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
};

var root = new TreeNode(3);
root.left = new TreeNode(9);
root.right = new TreeNode(20);
console.log(minDepth(root));

var balancedTree = new TreeNode(3);
balancedTree.left = new TreeNode(9);
balancedTree.right = new TreeNode(20);
balancedTree.right.left = new TreeNode(15);
balancedTree.right.right = new TreeNode(7);

console.log(minDepth(balancedTree));

var notBalanceTree = new TreeNode(1);
notBalanceTree.left = new TreeNode(2);
notBalanceTree.right = new TreeNode(2);
notBalanceTree.left.left = new TreeNode(3);
notBalanceTree.left.right = new TreeNode(3);
notBalanceTree.left.left.left = new TreeNode(4);
notBalanceTree.left.left.right = new TreeNode(4);
notBalanceTree.right.left = new TreeNode(2);

console.log(minDepth(notBalanceTree));