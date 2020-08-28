/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P022_Binary_Tree_Zigzag_Level_Order_Traversal {
	public static void main(String[] args) {
		P022_Binary_Tree_Zigzag_Level_Order_Traversal solution = new P022_Binary_Tree_Zigzag_Level_Order_Traversal();
		TreeNode root = solution.buildTree();
		List<List<Integer>> result = solution.zigzagLevelOrder(root);
		System.out.println(result);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		boolean zigzag = false;
		while (!queue.isEmpty()) {
			List<Integer> elements = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (zigzag) {
					elements.add(0, node.val);
				} else {
					elements.add(node.val);
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(elements);
			zigzag = !zigzag;
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
