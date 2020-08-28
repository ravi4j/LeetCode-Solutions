/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P002_Binary_Tree_Level_Order_Traversal_II {
	public static void main(String[] args) {
		P002_Binary_Tree_Level_Order_Traversal_II solution = new P002_Binary_Tree_Level_Order_Traversal_II();
		TreeNode root = solution.buildTree();
		List<List<Integer>> results = solution.levelOrderBottom(root);
		System.out.println(results);
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return Collections.EMPTY_LIST;
		}
		List<List<Integer>> result = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(0, level);
		}
		return result;
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
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
