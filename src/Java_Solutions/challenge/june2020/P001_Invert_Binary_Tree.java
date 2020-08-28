/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.ArrayDeque;
import java.util.Deque;

public class P001_Invert_Binary_Tree {
	public static void main(String[] args) {
		P001_Invert_Binary_Tree solution = new P001_Invert_Binary_Tree();
		TreeNode root = solution.buildTree();
		solution.printLevelOrder(root);
		root = solution.invertTree(root);
		solution.printLevelOrder(root);

	}

	public TreeNode invertTree(TreeNode root) {
		if(root == null){
			return null;
		}
		invertTree(root.left);
		invertTree(root.right);
		TreeNode temp =  root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}

	private void printLevelOrder(TreeNode root) {
		if (root == null) {
			System.out.printf(" null ");
			return;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.printf("%d ", node.val);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		System.out.println();
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
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

