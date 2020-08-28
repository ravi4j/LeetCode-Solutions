/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P027_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public static void main(String[] args) {
		P027_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal solution = new P027_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };
		int[] postorder = new int[] { 9, 15, 7, 20, 3 };
		TreeNode root = solution.buildTree(inorder, postorder);
		solution.printInOrder(root);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTree(int[] inorder, int istart, int iend, int[] postOrder, int pstart, int pend) {
		if (istart > iend || pstart > pend) {
			return null;
		}
		int rootVal = postOrder[pend];
		TreeNode root = new TreeNode(rootVal);
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootVal) {
				k = i;
				break;
			}
		}
		root.left = buildTree(inorder, istart, k - 1, postOrder, pstart, pstart + k - (istart + 1));
		root.right = buildTree(inorder, k + 1, iend, postOrder, pstart + k - istart, pend - 1);
		return root;
	}

	private void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.printf("%d ", root.val);
		printInOrder(root.right);
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
