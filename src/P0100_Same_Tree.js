/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
    if (p === null && q === null) return true;
    if (p === null || q === null) return false;

    if (p.val === q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    return false;
};

var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};


var tree1 = new TreeNode(2);
tree1.left = new TreeNode(1);;
tree1.right = new TreeNode(3);
console.log(isSameTree(tree1, tree1));
var tree2 = new TreeNode(1);
tree2.left = new TreeNode(2);;
tree2.right = new TreeNode(3);
console.log(isSameTree(tree1, tree2));