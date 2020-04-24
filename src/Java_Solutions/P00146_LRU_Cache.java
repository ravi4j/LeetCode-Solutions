/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

import java.util.HashMap;
import java.util.Map;

public class P00146_LRU_Cache {

	public static void main(String[] args) {
		System.out.println("Cache... ");
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4

		System.out.println("Cache1... ");
		LRUCache cache1 = new LRUCache(2);
		cache1.put(2, 1);
		cache1.put(1, 1);
		cache1.put(2, 3);
		cache1.put(4, 1);
		System.out.println(cache1.get(1));       // returns -1
		System.out.println(cache1.get(2));       // returns 3
	}

	static class LRUCache {
		private int capacity;
		private ListNode head;
		private ListNode tail;
		private Map<Integer, ListNode> storage;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.storage = new HashMap<>(capacity);
		}

		public int get(int key) {
			if (!storage.containsKey(key)) {
				return -1;
			}
			ListNode node = storage.get(key);
			remove(node);
			offer(node);
			return node.value;
		}

		public void put(int key, int value) {
			if (storage.containsKey(key)) {
				ListNode node = storage.get(key);
				node.value = value;
				remove(node);
				offer(node);
			} else {
				if (storage.size() >= capacity) {
					storage.remove(tail.key);
					remove(tail);
				}
				ListNode node = new ListNode(key, value);
				offer(node);
				storage.put(key, node);
			}
		}

		// Remove Node from the list
		private void remove(ListNode node) {
			if (node.prev != null) {
				node.prev.next = node.next;
			} else {
				head = node.next;
			}

			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				tail = node.prev;
			}
		}

		// Add at front
		private void offer(ListNode node) {
			if (head != null) {
				head.prev = node;
			}

			node.next = head;
			node.prev = null;
			head = node;

			if (tail == null) {
				tail = head;
			}
		}

		private class ListNode {
			int key;
			int value;
			ListNode next;
			ListNode prev;

			ListNode(int key, int value) {
				this.key = key;
				this.value = value;
				this.prev = null;
				this.next = null;
			}
		}
	}

}
