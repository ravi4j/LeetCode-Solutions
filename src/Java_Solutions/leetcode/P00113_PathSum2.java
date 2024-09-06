package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P00113_PathSum2 {

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<Integer> left = new ArrayList<Integer>();
		left.add(root.val);
		dfs(root, sum - root.val, result, left);
		return result;
	}

	public static void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> left) {
		if (root.left == null && root.right == null && sum == 0) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(left);
			result.add(temp);
		}

		if (root.left != null) {
			left.add(root.left.val);
			dfs(root.left, sum - root.left.val, result, left);
			left.remove(left.size() - 1);
		}

		if (root.right != null) {
			left.add(root.right.val);
			dfs(root.right, sum - root.right.val, result, left);
			left.remove(left.size() - 1);
		}
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(4);
		tree.left.left = new TreeNode(11);
		tree.left.left.left = new TreeNode(7);
		tree.left.left.right = new TreeNode(2);
		tree.right = new TreeNode(8);
		tree.right.left = new TreeNode(13);
		tree.right.right = new TreeNode(4);
		tree.right.right.left = new TreeNode(5);
		tree.right.right.right = new TreeNode(1);
		int sum = 22;
		List<List<Integer>> paths = pathSum(tree, sum);
		System.out.println(Arrays.asList(paths).toString());
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
