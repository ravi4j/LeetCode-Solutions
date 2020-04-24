/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P00145_Binary_Tree_Postorder_Traversal {
	public static void main(String[] args) {
		P00145_Binary_Tree_Postorder_Traversal solution = new P00145_Binary_Tree_Postorder_Traversal();
		TreeNode root = solution.buildTree();
		List<Integer> postOrder = solution.postorderTraversal(root);
		System.out.println(postOrder);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<Integer> postOrder = new ArrayList<>();
		TreeNode previous = null;
		TreeNode current;
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.peek();
			if (previous == null || previous.left == current || previous.right == current) {
				if (current.left != null) {
					stack.push(current.left);
				} else if (current.right != null) {
					stack.push(current.right);
				} else {
					stack.pop();
					postOrder.add(current.val);
				}
			} else if (current.left == previous) {
				if (current.right != null) {
					stack.push(current.right);
				} else {
					stack.pop();
					postOrder.add(current.val);
				}
			} else if (current.right == previous) {
				stack.pop();
				postOrder.add(current.val);
			}
			previous = current;
		}
		return postOrder;
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		return root;
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
