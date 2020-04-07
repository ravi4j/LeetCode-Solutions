/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
    var pre = null,
        first = null,
        second = null,
        temp = null;
    while (root !== null) {
        if (root.left !== null) {
            temp = root.left;
            //while
            while (temp.right !== null && temp.right !== root)
                temp = temp.right;

            if (temp.right !== null) {
                // restore the orginal tree by removing the treading
                if (pre !== null && pre.val > root.val) {
                    if (first === null)
                        first = pre;
                    second = root;
                }
                pre = root;
                temp.right = null;
                root = root.right;
            } else {
                // threading
                temp.right = root;
                root = root.left;
            }
        } else {
            if (pre !== null && pre.val > root.val) {
                if (first === null)
                    first = pre;
                second = root;
            }
            pre = root;
            root = root.right;
        }
    }
    // Swap the value
    if (first !== null && second !== null) {
        var t = first.val;
        first.val = second.val;
        second.val = t;
    }
};

var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};

var inOrderTraversal = function(root, array) {
    if (root === null) return;
    inOrderTraversal(root.left, array);
    array.push(root.val);
    inOrderTraversal(root.right, array);
};

var tree1 = new TreeNode(1);
tree1.left = new TreeNode(2);;
tree1.right = new TreeNode(3);
var result = [];
inOrderTraversal(tree1, result);
console.log("Before - >  [ " + result + " ]");
result.splice(0, result.length);
recoverTree(tree1);
inOrderTraversal(tree1, result);

console.log("Recovered Binary Tree - >  [ " + result + " ]");