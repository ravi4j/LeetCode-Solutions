/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P012_Insert_Delete_GetRandom {
	public static void main(String[] args) {
		P012_Insert_Delete_GetRandom solution = new P012_Insert_Delete_GetRandom();
		// Init an empty set.
		RandomizedSet randomSet = solution.createRandomizedSet();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomSet.insert(1);

		// Returns false as 2 does not exist in the set.
		randomSet.remove(2);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(2);

		// getRandom should return either 1 or 2 randomly.
		System.out.println(randomSet.getRandom());

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(1);

		// 2 was already in the set, so return false.
		randomSet.insert(2);

		// Since 2 is the only number in the set, getRandom always return 2.
		System.out.println(randomSet.getRandom());
	}

	private RandomizedSet createRandomizedSet() {
		return new RandomizedSet();
	}

	class RandomizedSet {
		private List<Integer> values;
		private Map<Integer, Integer> index;

		/**
		 * Initialize your data structure here.
		 */
		public RandomizedSet() {
			values = new ArrayList<>();
			index = new HashMap<>();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
		 */
		public boolean insert(int val) {
			if (index.containsKey(val)) {
				return false;
			}
			values.add(val);
			index.put(val, values.size() - 1);
			return true;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified element.
		 */
		public boolean remove(int val) {
			if (!index.containsKey(val)) {
				return false;
			}
			int position = index.get(val);
			values.set(position, values.get(values.size() - 1));
			index.put(values.get(position), position);
			values.remove(values.size() - 1);
			index.remove(val);
			return true;
		}

		/**
		 * Get a random element from the set.
		 */
		public int getRandom() {
			return values.get(((int) (Math.random() * values.size())));
		}
	}

}
