/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P028_Reconstruct_Itinerary {
	Map<String, PriorityQueue<String>> map = new HashMap<>();
	LinkedList<String> result = new LinkedList<>();

	public static void main(String[] args) {
		P028_Reconstruct_Itinerary solution = new P028_Reconstruct_Itinerary();
		List<List<String>> tickets = Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"),
				Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));
		List<String> result = solution.findItinerary(tickets);
		System.out.println(result);

		tickets = Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "ATL"),
				Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO"));
		result = solution.findItinerary(tickets);
		System.out.println(result);
	}

	public List<String> findItinerary(List<List<String>> tickets) {
		if (tickets == null || tickets.size() == 0) {
			return Collections.EMPTY_LIST;
		}
		for (List<String> ticket : tickets) {
			if (!map.containsKey(ticket.get(0))) {
				PriorityQueue<String> q = new PriorityQueue<>();
				map.put(ticket.get(0), q);
			}
			map.get(ticket.get(0)).offer(ticket.get(1));
		}
		dfs("JFK");
		return result;
	}

	private void dfs(String key) {
		PriorityQueue<String> q = map.get(key);
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
		result.addFirst(key);
	}
}
