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

public class P009_Maximum_Width_of_Binary_Tree {
	public static void main(String[] args) {
		P009_Maximum_Width_of_Binary_Tree solution = new P009_Maximum_Width_of_Binary_Tree();
		TreeNode root = solution.buildTree1();
		int result = solution.widthOfBinaryTree(root);
		System.out.println(result); // 4

		root = solution.buildTree2();
		result = solution.widthOfBinaryTree(root);
		System.out.println(result); // 2

		root = solution.buildTree3();
		result = solution.widthOfBinaryTree(root);
		System.out.println(result); // 2

		root = solution.buildTree4();
		result = solution.widthOfBinaryTree(root);
		System.out.println(result); // 8
	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		List<Integer> idx = new ArrayList<>();
		idx.add(0);
		int result = 1;
		queue.offer(root);
		while (!queue.isEmpty()) {
			result = Math.max(result, idx.get(idx.size() - 1) - idx.get(0) + 1);
			List<Integer> levelIndexList = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
					levelIndexList.add(idx.get(i) * 2);
				}
				if (node.right != null) {
					queue.offer(node.right);
					levelIndexList.add(idx.get(i) * 2 + 1);
				}
			}
			idx = levelIndexList;
		}
		return result;
	}

	private TreeNode buildTree1() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		return root;
	}

	private TreeNode buildTree2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		return root;
	}

	private TreeNode buildTree3() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		return root;
	}

	private TreeNode buildTree4() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(9);
		root.left.left.left = new TreeNode(6);
		root.right.right.right = new TreeNode(7);
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
