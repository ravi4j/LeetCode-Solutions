/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    var holder = [];
    inorderTraversalHelper(root, holder);
    return holder;
};

var inorderTraversalHelper = function(root, holder) {
    if (root === null)
        return;
    inorderTraversalHelper(root.left, holder);
    holder.push(root.val);
    inorderTraversalHelper(root.right, holder);
}


var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};

var root = new TreeNode(1);
root.left = null;
root.right = new TreeNode(2);
root.right.left = new TreeNode(3);

var result = inorderTraversal(root);
console.log(result);