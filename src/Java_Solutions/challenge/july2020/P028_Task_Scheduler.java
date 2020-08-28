/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.july2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P028_Task_Scheduler {
	public static void main(String[] args) {
		P028_Task_Scheduler solution = new P028_Task_Scheduler();
		char[] tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		int result = solution.leastInterval(tasks, n);
		System.out.println(result); // 8

		tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
		n = 0;
		result = solution.leastInterval(tasks, n);
		System.out.println(result); // 6

		tasks = new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		n = 2;
		result = solution.leastInterval(tasks, n);
		System.out.println(result); // 16
	}

	public int leastInterval(char[] tasks, int n) {

		int[] taskFrequency = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			taskFrequency[tasks[i] - 'A'] += 1;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < taskFrequency.length; i++) {
			if (taskFrequency[i] > 0) {
				pq.offer(taskFrequency[i]);
			}
		}

		int interval = 0;
		while (!pq.isEmpty()) {
			List<Integer> nextList = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				if (!pq.isEmpty()) {
					if (pq.peek() - 1 > 0) {
						nextList.add(pq.poll() - 1);
					} else {
						pq.poll();
					}
				}
				interval++;
				if (pq.isEmpty() && nextList.size() == 0) {
					break;
				}
			}
			for (Integer next : nextList) {
				pq.offer(next);
			}
		}
		return interval;
	}
}
