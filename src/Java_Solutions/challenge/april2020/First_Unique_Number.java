/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class First_Unique_Number {
	public static void main(String[] args) {
		FirstUnique firstUnique = new FirstUnique(new int[] { 2, 3, 5 });
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(5);            // the queue is now [2,3,5,5]
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
		System.out.println(firstUnique.showFirstUnique()); // return 3
		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
		System.out.println(firstUnique.showFirstUnique()); // return -1
		System.out.println("========================");
		firstUnique = new FirstUnique(new int[] { 7, 7, 7, 7, 7, 7 });
		System.out.println(firstUnique.showFirstUnique()); // return -1
		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
		firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
		System.out.println(firstUnique.showFirstUnique()); // return 17
		System.out.println("========================");
		firstUnique = new FirstUnique(new int[] { 809 });
		System.out.println(firstUnique.showFirstUnique()); // return 809
		firstUnique.add(809);          // the queue is now [809,809]
		System.out.println(firstUnique.showFirstUnique()); // return -1

	}

	static class FirstUnique {
		private Set<Integer> unique = new LinkedHashSet<>();
		private Set<Integer> seen = new HashSet<>();

		public FirstUnique(int[] nums) {
			for (int num : nums) {
				add(num);
			}
		}

		public int showFirstUnique() {
			return unique.isEmpty() ? -1 : unique.iterator().next();
		}

		public void add(int value) {
			if (seen.contains(value)) {
				unique.remove(value);
			} else {
				seen.add(value);
				unique.add(value);
			}
		}
	}
}
