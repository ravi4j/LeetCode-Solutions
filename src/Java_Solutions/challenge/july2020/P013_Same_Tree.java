/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

public class P013_Same_Tree {
	public static void main(String[] args) {
		P013_Same_Tree solution = new P013_Same_Tree();
		TreeNode p = solution.buildTree();
		TreeNode q = solution.buildTree();
		boolean result = solution.isSameTree(p, q);
		System.out.println(result); // true

		p = solution.buildTree1();
		q = solution.buildTree2();
		result = solution.isSameTree(p, q);
		System.out.println(result); // false

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

	private TreeNode buildTree() {
		return new TreeNode(1, new TreeNode(2), new TreeNode(3));
	}

	private TreeNode buildTree1() {
		return new TreeNode(1, new TreeNode(2), null);
	}

	private TreeNode buildTree2() {
		return new TreeNode(1, null, new TreeNode(2));
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
