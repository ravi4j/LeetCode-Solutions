/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

public class P018_H_Index_II {
	public static void main(String[] args) {
		P018_H_Index_II solution = new P018_H_Index_II();
		int[] citations = new int[] { 0, 1, 3, 5, 6 };
		int result = solution.hIndex(citations);
		System.out.println(result); // 3
	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		int left = 0;
		int right = citations.length - 1;
		int length = citations.length;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (citations[mid] == length - mid) {
				return length - mid;
			} else if (citations[mid] < length - mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (citations[left] >= length - left) {
			return length - left;
		}

		if (citations[right] >= length - right) {
			return length - right;
		}
		return 0;
	}
}
