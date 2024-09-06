package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P00173_Binary_Search_Tree_Iterator {
	public static void main(String[] args) {
		P00173_Binary_Search_Tree_Iterator solution = new P00173_Binary_Search_Tree_Iterator();
		TreeNode root = solution.buildTree();
		BSTIterator iterator = solution.createBSTIterator(root);
		System.out.println(iterator.next()); // return 3
		System.out.println(iterator.next()); // return 7
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 9
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 15
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 20
		System.out.println(iterator.hasNext()); // return false
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		return root;
	}

	private BSTIterator createBSTIterator(TreeNode root) {
		return new BSTIterator(root);
	}

	private class BSTIterator {

		private Deque<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new ArrayDeque<>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode node = stack.pop();
			int result = node.val;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return result;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}

	class TreeNode {
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
