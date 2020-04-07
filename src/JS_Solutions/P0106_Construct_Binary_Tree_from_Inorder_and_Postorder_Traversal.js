/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
    return constructTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
};

var constructTree = function(postorder, pstart, pend, inorder, istart, iend) {

    if (pstart > pend || istart > iend) {
        return null;
    }

    var val = postorder[pend];
    var node = new TreeNode(val);
    var index = 0;
    for (var i = 0; i < inorder.length; i++) {
        if (inorder[i] === val) {
            index = i;
            break;
        }
    }
    node.left = constructTree(postorder, pstart, pstart + index - (istart + 1), inorder, istart, index - 1);
    node.right = constructTree(postorder, pstart + index - istart, pend - 1, inorder, index + 1, iend);
    return node;
};


var TreeNode = function(val) {
    this.val = val;
    this.left = null;
    this.right = null;
};

var postorder = [9, 15, 7, 20, 3];
var inorder = [9, 3, 15, 20, 7];
var root = buildTree(inorder, postorder);

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