/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
	public static void main(String[] args) {
		Construct_Binary_Search_Tree_from_Preorder_Traversal solution = new Construct_Binary_Search_Tree_from_Preorder_Traversal();
		int[] preOrderArray = new int[] { 8, 5, 1, 7, 10, 12 };
		TreeNode root = solution.bstFromPreorder(preOrderArray);
		solution.preOrderTraversal(root);
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		return bstFromPreorder(preorder, 0, preorder.length - 1);
	}

	public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[start]);
		int index;
		for (index = start; index <= end; index++) {
			if (preorder[index] > node.val) {
				break;
			}
		}
		node.left = bstFromPreorder(preorder, start + 1, index - 1);
		node.right = bstFromPreorder(preorder, index, end);

		return node;
	}

	private void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.printf("%d ", root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
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
