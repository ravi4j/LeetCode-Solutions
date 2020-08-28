/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.may2020;

public class First_Bad_Version {

	public static void main(String[] args) {
		First_Bad_Version solution = new First_Bad_Version();
		int result = solution.firstBadVersion(10);
		System.out.println(result);
	}

	public int firstBadVersion(int n) {

		if (n == 0) {
			return -1;
		}

		if (n == 1) {
			return 1;
		}

		int start = 1, end = n, mid;
		while (start < end) {
			mid = start + (end - start) / 2;
			if (VersionControl.isBadVersion(mid) == false) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		if (VersionControl.isBadVersion(start) == true) {
			return start;
		} else if (VersionControl.isBadVersion(end) == true) {
			return end;
		} else {
			return -1; // not found
		}

	}

}

class VersionControl {
	public static boolean isBadVersion(int k) {
		return k > 3;
	}
}
