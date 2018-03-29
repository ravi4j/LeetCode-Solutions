/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums) {
    if (nums == null || nums.length == 0) {
        return null;
    }
    return helper(nums, 0, nums.length - 1);
};

var helper = function(nums, start, end) {
    if (start > end) {
        return null;
    }
    var mid = start + parseInt((end - start) / 2);
    var node = new TreeNode(nums[mid]);
    node.left = helper(nums, start, mid - 1);
    node.right = helper(nums, mid + 1, end);
    return node;
};

var TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
};

var nums = [-10, -3, 0, 5, 9];
var root = sortedArrayToBST(nums);


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