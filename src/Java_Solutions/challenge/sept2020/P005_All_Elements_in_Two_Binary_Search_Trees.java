/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.sept2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P005_All_Elements_in_Two_Binary_Search_Trees {

	public static void main(String[] args) {
		P005_All_Elements_in_Two_Binary_Search_Trees solution = new P005_All_Elements_in_Two_Binary_Search_Trees();
		TreeNode root1 = solution.buildTree1();
		TreeNode root2 = solution.buildTree2();
		List<Integer> list = solution.getAllElements(root1, root2);
		System.out.println(list); //[0,1,1,2,3,4]

	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> result = new ArrayList<>();
		if (root1 == null && root2 == null) {
			return result;
		}
		addToList(root1, result);
		addToList(root2, result);
		Collections.sort(result);
		return result;
	}

	private void addToList(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		addToList(root.left, result);
		addToList(root.right, result);
	}

	private TreeNode buildTree1() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		return root;
	}

	private TreeNode buildTree2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(3);
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
