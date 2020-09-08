/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

public class P008_Sum_of_Root_To_Leaf_Binary_Numbers {
	public static void main(String[] args) {
		P008_Sum_of_Root_To_Leaf_Binary_Numbers solution = new P008_Sum_of_Root_To_Leaf_Binary_Numbers();
		TreeNode root = solution.buildTree();
		int result = solution.sumRootToLeaf(root);
		System.out.println(result);// 22
	}

	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, 0);
	}

	public int sumRootToLeaf(TreeNode root, int current) {
		if (root == null) {
			return 0;
		}
		current = current << 1;
		current += root.val;
		if (isLeaf(root)) {
			return current;
		}
		return sumRootToLeaf(root.left, current) + sumRootToLeaf(root.right, current);
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
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
