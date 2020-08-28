/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Cousins_in_Binary_Tree {
	public static void main(String[] args) {
		Cousins_in_Binary_Tree solution = new Cousins_in_Binary_Tree();
		TreeNode root = solution.buildTree1();
		boolean result = solution.isCousins(root, 4, 3);
		System.out.println(result);
		root = solution.buildTree2();
		result = solution.isCousins(root, 4, 5);
		System.out.println(result);
	}

	public TreeNode buildTree1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		return root;
	}

	public TreeNode buildTree2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		return root;
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null || root.left == null || root.right == null) {
			return false;
		}
		Map<Integer, Integer> level = new HashMap<>();
		Map<Integer, Integer> parent = new HashMap<>();
		int depth = 0;
		TreeNode dummyNode = new TreeNode(-1);
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		queue.offer(dummyNode);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.val == -1) {
				depth += 1;
				if (!queue.isEmpty()) {
					queue.offer(dummyNode);
				}
			} else {
				level.put(node.val, depth);
				if (node.left != null) {
					queue.offer(node.left);
					parent.put(node.left.val, node.val);
				}
				if (node.right != null) {
					queue.offer(node.right);
					parent.put(node.right.val, node.val);
				}
			}
		}
		return (level.get(x) == level.get(y)) && (parent.get(x) != parent.get(y));
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
