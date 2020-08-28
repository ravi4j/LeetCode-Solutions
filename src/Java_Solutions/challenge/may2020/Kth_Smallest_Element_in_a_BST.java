/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.concurrent.atomic.AtomicInteger;

public class Kth_Smallest_Element_in_a_BST {
	public static void main(String[] args) {
		Kth_Smallest_Element_in_a_BST solution = new Kth_Smallest_Element_in_a_BST();
		TreeNode root = solution.buildTree();
		int result = solution.kthSmallest(root, 1);
		System.out.println(result);

		root = solution.buildTree2();
		result = solution.kthSmallest(root, 3);
		System.out.println(result);
	}

	public int kthSmallest(TreeNode root, int k) {
		AtomicInteger i = new AtomicInteger(0);
		return kthSmallest(root, i, k);
	}

	public int kthSmallest(TreeNode root, AtomicInteger i, int k) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		int left = kthSmallest(root.left, i, k);

		if (left != Integer.MAX_VALUE) {
			return left;
		}

		if (i.incrementAndGet() == k) {
			return root.val;
		}

		return kthSmallest(root.right, i, k);

	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		return root;
	}

	private TreeNode buildTree2() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
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
