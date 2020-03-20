/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

public class P00124_Binary_Tree_Maximum_Path_Sum {

	public static void main(String[] args) {
		P00124_Binary_Tree_Maximum_Path_Sum solution = new P00124_Binary_Tree_Maximum_Path_Sum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int max = solution.maxPathSum(root);
		System.out.println(max);
	}

	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		getSubTreeMaxSum(root , max);
		return max[0];
	}

	public int getSubTreeMaxSum(TreeNode node , int[] max){
		if(node == null){
			return 0;
		}
		int left = getSubTreeMaxSum(node.left , max);
		int right = getSubTreeMaxSum(node.right , max);

		int current = Math.max(node.val , Math.max(node.val + left , node.val + right));
		max[0] = Math.max( max[0] , Math.max(current , left + node.val + right));
		return current;
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