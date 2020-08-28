/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.august2020;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class P013_Iterator_for_Combination {
	public static void main(String[] args) {
		CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false
	}

}

class CombinationIterator {
	private Set<String> combinationSet = new TreeSet<>();
	private Iterator<String> combItr;

	public CombinationIterator(String characters, int combinationLength) {
		generate(characters, combinationLength);
		this.combItr = combinationSet.iterator();
	}

	public String next() {
		return combItr.hasNext() ? combItr.next() : "";
	}

	public boolean hasNext() {
		return combItr.hasNext();
	}

	private void generate(String characters, int combinationLength) {
		int mask = 1 << characters.length();
		StringBuilder combStr = new StringBuilder();
		for (int i = 1; i < mask; i++) {
			int num = i;
			int index = 0;
			while (num > 0) {
				if ((num & 1) == 1) {
					combStr.append(characters.charAt(index));
				}
				num >>= 1;
				index++;
			}
			if (combStr.length() == combinationLength) {
				combinationSet.add(combStr.toString());
			}
			combStr.delete(0, combStr.length());
		}
	}
}