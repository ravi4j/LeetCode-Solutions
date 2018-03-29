/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    return constuctTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
};

var constuctTree = function(preorder, prestart, preend, inorder, instart, inend) {
    if (prestart > preend || instart > inend) {
        return null;
    }
    var val = preorder[prestart];
    var p = new TreeNode(val);
    var index = 0;

    for (var i = 0; i < inorder.length; i++) {
        if (inorder[i] === val) {
            index = i;
            break;
        }
    }
    p.left = constuctTree(preorder, prestart + 1, prestart + (index - instart), inorder, instart, index - 1);
    p.right = constuctTree(preorder, prestart + (index - instart) + 1, preend, inorder, index + 1, inend);
    return p;
};

var TreeNode = function(val) {
    this.val = val;
    this.left = null;
    this.right = null;
};

var preorder = [3, 9, 20, 15, 7];
var inorder = [9, 3, 15, 20, 7];
var root = buildTree(preorder, inorder);

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

var result = inorderTraversal(root);
console.log(result);