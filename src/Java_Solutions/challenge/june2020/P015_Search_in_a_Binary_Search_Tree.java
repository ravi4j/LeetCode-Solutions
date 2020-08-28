/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P015_Search_in_a_Binary_Search_Tree {
	public static void main(String[] args) {
		P015_Search_in_a_Binary_Search_Tree solution = new P015_Search_in_a_Binary_Search_Tree();
		TreeNode root = solution.buildTree();
		int val = 2;
		TreeNode subRoot = solution.searchBST(root, 2);
		solution.printTree(subRoot);
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (val < root.val) {
				root = root.left;
			} else if (val > root.val) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	public TreeNode searchBSTRecusive(TreeNode root, int val) {
		if (root == null) {
			return null;
		}

		if (root.val == val) {
			return root;
		} else if (val < root.val) {
			return searchBST(root.left, val);
		} else if (val > root.val) {
			return searchBST(root.right, val);
		}
		return null;
	}

	private void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.printf("%d ", root.val);
		printTree(root.left);
		printTree(root.right);
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		return root;
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
