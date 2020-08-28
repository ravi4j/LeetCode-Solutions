/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.ArrayDeque;
import java.util.Deque;

public class Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree {

	public static void main(String[] args) {
		Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree solution = new Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree();
		TreeNode root = solution.buildTree(new Integer[] { 0, 1, 0, 0, 1, 0, null, null, 1, 0, 0 });
		solution.levelOrder(root);
		int[] arr = new int[] { 0, 1, 0, 1 };
		boolean valid = solution.isValidSequence(root, arr);
		System.out.println(valid);

		root = solution.buildTree(
				new Integer[] { 6, 4, 5, 3, 6, 9, 3, 3, 2, 4, 6, 1, 9, 1, 3, 8, 2, 3, 3, 1, 6, 3, 1, 2, 8, 1, 1, 3, 9, 2, 7, 3, 3,
						6, 6, 2, 2, 4, 7, 9, 0, 2, 1, 6, 8, 8, 7, 9, 3, 5, 9, 9, null, 8, 5, 1, 1, null, 0, 3, 2, null, 6, 3, 2, 1,
						3, 2, 0, 4, 4, 0, 0, 0, 1, 4, 7, 6, 7, 4, 0, 6, 4, 3, 4, 1, 9, 6, 1, 8, 3, 5, 3, 9, 5, 3, 3, 0, 2, 1, 6, 8,
						5, 5, 7, 4, 4, 4, null, 3, 5, 0, 4, 1, 6, 4, null, 4, null, null, null, 3, 9, 2, null, 0, 1, 3, 0, 9, 5, 2,
						4, 4, 8, 1, 2, 5, 1, 5, 8, 2, null, 0, 9, 0, null, 0, 9, 5, 0, 4, 3, 1, null, 1, null, 2, 9, 5, 4, 3, 3, 0,
						4, null, null, 4, 2, null, null, null, null, null, 5, null, 7, 2, 5, 8, 4, null, null, 9, 9, 4, 8, 6, 5, 4,
						2, 0, 7, 2, null, 7, 5, 2, 0, 9, 9, 2, 8, 2, null, 5, 1, null, 0, 7, null, 7, 8, 7, 5, 9, 1, null, null, 0,
						4, 6, 1, null, null, 0, 3, 3, 2, 5, 6, 3, 5, 6, null, 4, 4, null, 0, 0, 7, 8, null, 6, 2, 6, null, 2, null,
						6, 7, 4, 2, null, null, 8, 4, 4, 8, 7, null, 8, 5, 7, 0, null, 0, 8, 0, 0, null, 8, 0, 8, 5, 1, null, 0, 7,
						1, 7, 3, 1, 3, 7, 9, 0, 3, 5, 7, 2, null, 7, 1, 7, 1, 1, null, 0, 7, 6, 4, 3, 7, 0, 2, null, 0, 1, null,
						null, null, null, 3, null, 8, 5, 2, 1, null, 5, null, null, null, 5, 1, 3, 3, null, 1, null, 3, 7, null, 1,
						1, 0, 8, null, 0, 5, null, null, null, 1, null, 0, 6, 7, 8, 0, 7, 5, 3, 2, 6, 2, 3, 1, null, 7, 3, 1, 7, 8,
						6, null, null, null, 1, 6, 7, 8, 5, 1, 9, 3, 9, 8, null, null, 3, null, 3, 1, null, null, null, null, 6, 4,
						null, null, 1, 5, null, null, 4, 1, 8, 6, null, null, 4, null, null, null, null, null, null, 4, null, null,
						null, null, 6, 5, 8, 9, null, 9, null, null, null, 0, 7, null, 5, 4, 7, 0, 0, 1, 3, 2, 8, 6, 7, 9, null, 4,
						null, 1, 8, null, 5, 9, null, null, 7, null, 4, 3, 2, null, 2, null, null, null, 2, 0, 8, 7, 4, 1, 3, 9, 4,
						9, 4, null, 5, 5, 3, 6, null, null, 5, 3, null, null, null, null, 1, 1, 4, 9, 7, null, 4, 4, null, null, 7,
						3, null, 1, null, 9, 8, null, 6, 6, 6, 8, 9, 9, 0, 0, null, 2, null, null, null, 6, 2, 4, 5, 7, 0, null, 4,
						6, 6, null, null, 7, 0, null, null, null, null, null, 7, null, null, 5, 8, 0, null, null, 5, 7, null, 5, 6,
						8, 2, null, null, 0, 7, 1, 5, 1, 2, 0, 8, 8, null, 5, 5, 3, 6, 6, 1, 3, 1, 8, null, 2, 4, 1, 4, 3, 0, null,
						3, 0, null, 7, 2, 7, null, null, null, 2, null, null, 6, 6, null, 9, null, 0, null, null, null, 5, 0, null,
						null, null, 6, 3, null, null, 8, 4, null, 3, 8, 2, null, null, null, 9, 4, 0, 5, 7, 3, 8, null, 8, 3, 5, 6,
						9, 6, 6, 9, 9, null, 5, 8, null, 8, 4, 8, null, null, 8, 2, 5, 1, null, 8, null, null, null, null, 2, 8,
						null, null, 5, null, null, null, null, null, 0, null, null, null, null, null, 7, null, 1, 7, 0, null, null,
						6, 3, 0, 4, 1, 8, 2, 5, null, null, 2, null, 8, null, null, null, null, null, 6, null, 5, 0, null, 3, null,
						null, 5, 8, 1, null, 9, 9, null, 7, null, 8, null, 8, 7, null, 8, 1, 1, 2, 1, 8, null, null, 5, 0, 1, 0,
						null, 6, null, 3, 7, null, 0, null, 1, 9, 5, 5, 1, 9, 7, 7, 6, 7, 2, null, 2, 9, 4, 6, 7, 4, null, 3, 0,
						null, 0, 0, 9, 2, 0, 6, 2, 3, 5, 2, null, null, 2, 1, null, 5, 5, 7, 5, 4, 0, 8, 3, 6, 1, 3, null, null,
						null, null, null, 9, null, 6, 3, 0, null, null, null, null, 5, 6, 0, null, 6, 1, null, 1, null, null, 6, 7,
						5, null, null, null, null, 7, 6, 6, null, null, 7, null, 8, null, null, null, null, 1, null, null, 8, 1,
						null, null, null, null, 0, null, null, null, 2, null, 5, 6, 0, 1, null, 3, null, null, null, null, 2, null,
						5, 6, null, null, 8, null, 2, 3, null, 0, null, null, null, null, 1, null, 8, 3, 0, 6, null, 8, 5, 0, null,
						null, 6, null, null, null, null, null, null, null, null, 7, 2, null, null, 5, 6, 3, null, 1, null, 1, null,
						null, null, null, null, 5, null, null, null, 3, 5, null, 5, 1, 5, 1, 2, 7, 2, 3, 1, 0, 1, 2, 6, null, 0, 2,
						6, 9, 2, 3, 3, 0, 7, 9, 3, 7, 9, null, 5, null, 6, 6, 7, 5, null, 7, null, 4, null, null, 7, null, null,
						null, null, null, 1, 4, null, null, 5, null, null, null, 3, 7, null, null, 8, 1, null, 9, 6, null, null,
						null, null, 1, null, null, null, 7, 2, 7, null, 8, 5, null, 4, 3, 3, 0, 9, 8, null, 8, 9, 3, null, null,
						null, null, 4, null, null, 9, 2, null, null, 1, 4, null, null, 4, null, null, null, null, null, 4, null,
						null, 6, 2, null, 5, null, 6, null, 2, null, null, 5, 0, 1, 2, null, null, 5, 6, 3, null, 9, 8, 1, 4, 8,
						null, null, null, 8, 7, 7, null, 4, 3, 8, null, 1, 2, 1, 3, 8, 0, 8, 6, 9, 5, 0, 5, null, 6, 2, 0, 5, 6,
						null, null, 1, 0, 5, null, null, null, 6, 1, 9, null, 9, 8, 8, null, 3, null, null, 3, null, 1, 5, 8, 9, 6,
						null, 7, 0, 2, null, 7, null, null, null, null, null, 9, null, null, 4, 8, null, null, 2, 7, 4, null, null,
						null, 2, 2, 9, null, 8, null, 5, 9, null, null, null, null, null, null, null, null, null, 3, 9, null, 8,
						null, null, 1, null, 0, 6, 9, 2, 4, 6, 2, null, null, null, 4, 6, null, null, null, 2, 1, 8, null, 3, 3,
						null, 8, null, null, null, null, null, null, null, null, null, 1, 1, 2, 9, 5, 5, null, 8, 6, 5, 4, 4, null,
						9, 0, 7, 4, 1, null, null, 1, null, 4, 7, 5, null, null, 4, 3, null, null, 2, null, 2, 9, 6, 6, 2, null, 3,
						7, null, null, null, null, null, null, 0, null, null, null, null, null, null, 6, null, 4, 1, null, null, 5,
						7, null, null, 1, 7, 3, null, null, 6, 0, 5, 6, 0, 9, null, null, 3, 2, null, null, 3, 9, 4, null, 0, 1, 7,
						null, null, 3, null, null, 4, 8, null, null, null, 5, 3, null, null, null, 8, null, 5, 0, 7, null, 2, 3, 4,
						null, null, null, null, 9, 0, 2, 2, 8, null, 0, null, 8, 9, 3, 8, null, null, null, null, 0, null, null, 1,
						2, null, null, 4, null, null, null, 7, 1, null, null, null, 7, null, null, null, null, null, null, 2, null,
						7, 2, null, 3, null, 3, null, null, 2, 4, null, null, 2, 2, 5, 0, 9, null, 4, 5, null, 0, null, null, null,
						null, null, null, null, null, null, 5, null, null, null, null, null, 2, null, 5, null, null, null, null,
						null, null, 2, null, 5, 0, 8, 7, 5, 7, 6, 2, 9, 6, 5, 5, 4, 6, 4, 1, null, 6, 9, null, 8, 5, null, null,
						null, null, null, 6, 9, null, 1, null, null, 9, null, 1, null, 8, null, 9, 8, 6, null, 5, 3, 8, 0, 4, 3, 3,
						9, null, 0, 1, 7, null, null, 6, 4, 0, 2, 2, 4, 8, 8, null, 5, 3, 8, 8, 7, null, 6, 3, 0, 7, null, null,
						null, null, 2, null, 0, 7, 4, 2, null, null, 9, 9, null, null, null, null, null, 4, 5, 6, 1, null, 5, 8,
						null, 0, null, null, 2, null, null, null, 7, null, null, null, null, null, null, null, null, null, 6, 5, 4,
						6, 3, null, null, null, null, null, 9, null, null, null, 6, 9, null, null, 0, 6, 8, 3, null, 4, 3, null,
						null, 7, 1, null, null, 7, 2, 5, null, 3, null, null, 5, null, null, 4, null, null, 2, null, 9, null, null,
						null, null, null, 5, null, 8, 9, null, null, 2, null, 2, 7, null, null, null, 8, null, null, null, null,
						null, 9, 3, null, 8, 9, 8, null, 0, 7, null, null, null, null, 5, null, null, null, null, null, 5, null,
						null, 1, 1, 3, null, null, null, 5, null, null, null, 8, 0, 0, 4, null, 5, null, null, null, null, null,
						null, null, 4, 9, 2, null, null, null, null, 4, null, null, 2, 7, null, 8, 3, 8, null, 1, null, null, null,
						null, 3, 0, null, null, 4, null, null, 7, null, null, null, 8, null, 7, 5, 8, null, 9, null, null, 3, null,
						null, null, null, null, null, 1, null, null, null, 2, 0, 5, null, 1, null, null, null, 7, null, 5, null,
						null, null, 1, 2, 7, 4, 8, 6, 5, 5, 4, 8, 1, null, null, null, null, null, null, null, null, 0, null, null,
						null, null, null, null, null, 5, 3, 2, 8, null, null, 4, 5, null, 7, null, null, 8, null, null, 3, null,
						null, 1, 5, 5, 6, 4, 7, 3, null, null, null, 3, null, 2, null, null, 6, 0, 8, null, null, 1, null, null,
						null, 6, 0, 9, null, 6, null, null, 5, 5, 9, null, 2, null, 5, null, null, null, null, 9, 9, 6, 1, null,
						null, 9, 9, 0, null, null, null, 1, 9, 2, 5, 3, 3, null, null, null, null, null, 6, 8, 0, null, 5, null,
						null, 1, 5, null, null, null, 1, null, null, 9, null, null, 3, null, null, 9, 4, 5, 1, 9, 4, 1, 3, 7, 4,
						null, null, null, 0, 1, 8, 9, null, null, null, 6, null, null, null, null, null, null, 4, null, null, 2, 5,
						2, 2, null, 2, 9, null, 8, null, 2, 9, 5, 7, null, null, null, null, null, null, null, 7, 0, 0, null, null,
						7, 9, 2, 6, 8, 6, 2, 8, null, 5, null, null, 4, 3, 6, 6, null, 9, null, null, 0, 6, null, 2, null, 1, 4,
						null, null, null, null, null, 8, 0, null, null, null, 6, null, null, null, null, 1, null, 3, null, 4, null,
						null, null, null, 2, null, null, 2, null, null, null, null, 8, 8, 7, null, 9, null, 3, null, 1, 6, null,
						null, null, 5, 9, 1, null, null, 4, null, 1, null, null, null, null, null, null, 4, 5, 2, 0, 1, 8, null,
						null, null, null, null, null, 8, 0, null, 0, 8, 5, null, 4, null, null, null, 1, 3, null, 5, 9, null, null,
						null, null, null, 9, null, 8, null, null, null, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, null, null, 2, 7, 5, null, null, null, null, null, null, null, null, null, null,
						null, null, null, null, 9, null, 8, 0, null, null, 8, null, null, null, null, null, null, null, null, null,
						null, null, null, 1, null, null, 1, null, 2, null, 3, null, null, null, 8, 5, 4, 0, null, null, 2, 8, null,
						null, null, null, 2, null, null, 0, null, null, null, null, null, null, null, null, null, null, 3, 4, null,
						2, 1, 1, 9, 7, null, null, 5, null, null, 9, null, null, 3, 8, null, null, null, 1, 7, 6, null, null, null,
						8, null, 6, null, 6, 7, 3, null, null, null, 8, null, null, null, 4, 9, 4, 8, null, 8, 1, 0, 5, 9, null, 9,
						null, null, null, 4, 7, 4, null, 3, null, 3, null, 5, 8, null, null, null, null, null, null, 5, null, 2, 4,
						7, null, null, null, null, null, 6, 8, null, 7, null, null, null, null, 0, 7, null, null, 6, null, 1, 7, 8,
						null, null, 4, null, null, null, null, null, null, null, 5, 0, null, 7, 7, 1, null, null, null, null, null,
						null, 8, null, null, 2, 0, null, null, 6, 1, 6, 9, 3, 3, 1, 0, 7, null, 4, 4, null, null, 2, 5, 3, 9, null,
						7, 5, 3, 0, 5, null, 5, 6, 7, 1, null, 7, 0, 9, 8, 6, null, null, 7, null, null, 3, 8, null, null, 3, 4, 9,
						null, 5, null, null, 3, null, 6, 3, 2, null, null, 1, null, null, 5, null, null, null, null, 8, 0, null, 2,
						null, 7, null, null, 0, null, null, null, 0, null, null, null, 3, 2, null, null, null, null, 0, null, null,
						null, 9, 8, 0, 3, null, null, 1, null, 1, 2, null, null, null, null, 3, null, null, null, null, null, null,
						null, null, null, 1, null, 6, null, null, null, null, 9, null, null, 4, 4, 4, 9, null, 8, null, null, null,
						null, null, 1, null, 4, null, null, null, null, null, 8, null, 5, null, null, null, null, 9, null, 8, 3, 1,
						7, 3, 5, null, null, null, null, null, 8, 8, 9, 1, null, 7, 7, 8, 6, 5, 2, null, 3, null, 7, null, null,
						null, null, 9, null, null, 6, null, null, null, 8, null, null, null, null, 8, 6, null, null, 6, null, null,
						null, null, null, null, null, null, 4, null, null, null, null, null, null, null, null, 8, 9, 1, null, null,
						null, null, null, 8, 2, null, null, null, null, null, 2, 6, 1, null, null, null, null, null, 2, null, null,
						null, 3, 6, 1, 6, null, null, 9, 0, null, null, 4, 4, null, null, null, null, null, null, 2, null, null,
						null, null, null, null, 6, null, null, null, 2, 9, null, 6, 2, 2, null, 4, null, null, 5, 0, 8, null, null,
						0, null, 5, 8, null, null, null, 4, null, 7, 3, null, 1, 7, null, null, 7, null, 4, 9, null, null, null,
						null, null, 1, 6, null, null, null, 7, 4, null, 3, null, null, null, null, 0, 0, 3, 7, 0, null, 2, 5, 7,
						null, 9, 6, null, null, null, 4, 3, 5, null, null, null, 0, null, null, 8, 0, 5, 1, 8, null, null, null, 2,
						5, null, 5, 6, 7, null, 0, 1, 4, null, null, 5, null, 8, null, null, null, 5, null, 1, null, null, null,
						null, null, null, null, 9, null, 3, null, 8, null, null, null, null, null, null, 2, null, null, null, null,
						null, null, 2, 1, 5, 5, 0, 2, 7, null, null, null, null, null, null, 5, 8, null, null, null, 8, 7, 6, null,
						1, null, null, 0, 5, 5, 2, 9, 5, null, null, null, null, null, 3, 9, null, null, 8, null, 7, null, null,
						null, 0, null, null, null, null, 8, 6, null, 1, 6, null, 0, null, null, 9, null, null, 0, 6, 5, null, null,
						null, 0, null, 0, null, null, null, null, null, 6, 1, null, null, 7, 0, null, 0, 2, 1, 9, 3, null, null,
						null, null, null, 2, null, null, 0, null, null, null, null, null, 2, null, null, null, null, null, 3, null,
						null, null, null, null, null, null, 3, 4, 0, null, null, null, null, null, null, null, 1, 7, 8, null, 8,
						null, null, 4, null, 6, null, 4, null, 7, null, null, null, null, null, null, 0, null, null, null, 4, null,
						null, 7, 1, null, null, 3, 4, 3, 9, null, 0, 4, null, null, 3, 9, 2, 7, null, 8, 9, null, 8, null, null,
						null, 6, 2, 8, null, 7, null, null, null, null, null, null, null, null, 7, null, null, null, null, null, 0,
						null, 4, 0, null, null, null, null, 6, null, null, null, 7, 9, null, 3, null, null, null, null, null, 0,
						null, 2, null, 8, null, 3, 6, null, 6, null, null, null, 4, null, null, null, null, null, null, null, null,
						null, null, null, null, 4, null, 6, null, 5, 3, 0, null, 5, null, null, 0, 4, 4, null, null, null, 0, 5,
						null, null, null, 4, 6, 1, 4, 1, 7, null, null, null, 1, null, null, null, null, null, null, 1, null, 3, 5,
						null, null, null, null, 2, null, null, null, null, 0, 0, 6, null, null, 6, null, null, null, null, 9, 2,
						null, 4, 1, 1, 5, null, null, null, 7, 3, 5, null, null, 9, null, 4, null, null, 9, 3, null, null, 0, null,
						null, null, 3, null, null, null, null, 5, null, null, null, 6, null, 4, null, null, null, null, 2, null,
						null, null, null, null, null, null, 3, null, null, 3, null, null, 7, null, null, null, null, null, 6, null,
						2, null, null, null, null, 4, null, null, 4, null, null, 5, null, null, null, null, null, null, null, null,
						null, null, 0, null, 7, 5, null, 7, null, null, null, 7, 2, null, null, null, 0, null, 9, null, null, 6,
						null, 6, 2, 0, null, null, null, 4, 2, 4, 1, null, null, 7, null, null, null, null, 4, null, null, null,
						null, null, 5, null, null, null, null, 6, null, null, null, null, null, 4, null, null, null, null, null, 2,
						null, null, null, null, null, null, null, null, 3, 1, null, 9, 0, null, null, null, null, null, null, null,
						2, null, null, null, null, null, null, null, 4, 4, 3, null, null, 4, null, 9, 3, null, null, 9, null, 0, 2,
						null, null, null, null, null, null, null, null, 4, null, null, null, 2, null, null, 2, null, null, null,
						null, null, null, 2, null, 3, 4, 2, null, null, null, null, null, null, null, null, 1, null, null, null,
						null, null, null, 6, 4, null, null, null, null, null, null, null, 7, 9, 7, null, 9, null, 3, 0, null, 8, 4,
						null, null, null, 7, null, null, null, null, 6, null, null, null, 7, null, null, null, null, null, null,
						null, null, null, 8, 0, null, null, 5, 6, null, 1, null, null, 1, 7, null, null, null, 4, null, null, null,
						null, null, null, null, null, null, null, null, 6, 5, null, null, 8, null, null, null, null, null, 4, null,
						2, null, null, null, null, null, null, null, null, null, 1, null, null, null, 2, null, 6, null, null, null,
						1, null, null, 9, null, null, null, 8, null, null, null, null, null, null, null, 3 });
		arr = new int[] { 6, 4, 3, 2, 3, 2, 1, 0 };

		valid = solution.isValidSequence(root, arr);
		System.out.println(valid);
	}

	public boolean isValidSequence(TreeNode root, int[] arr) {
		return isValidSequence(root, arr, 0);
	}

	private boolean isValidSequence(TreeNode root, int[] arr, int index) {
		if (root == null || index == arr.length) {
			return false;
		}

		if (root.left == null && root.right == null && root.val == arr[arr.length - 1] && index == arr.length - 1) {
			return true;
		}

		return (index < arr.length && arr[index] == root.val) && (isValidSequence(root.left, arr, index + 1) || isValidSequence(
				root.right, arr, index + 1));
	}

	private void levelOrder(TreeNode root) {
		if (root == null) {
			System.out.printf(" null ");
			return;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.printf("%d ", node.val);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		System.out.println();
	}

	private TreeNode buildTree(Integer[] values) {
		TreeNode root = new TreeNode(-1);
		root = buildTree(values, root, 0);
		return root;
	}

	private TreeNode buildTree(Integer[] values, TreeNode root, Integer index) {
		if (index < values.length && values[index] != null) {
			TreeNode temp = new TreeNode(values[index]);
			root = temp;

			root.left = buildTree(values, root.left, 2 * index + 1);
			root.right = buildTree(values, root.right, 2 * index + 2);
		}
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
