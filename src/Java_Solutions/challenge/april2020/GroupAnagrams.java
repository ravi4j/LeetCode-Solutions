/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.april2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();
		String[] inputs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> lists = solution.groupAnagrams(inputs);
		for (List<String> list : lists) {
			System.out.println(list);
		}

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		if (strs == null || strs.length == 0) {
			return Collections.emptyList();
		}
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		return map.values().stream().collect(Collectors.toList());
	}

}
