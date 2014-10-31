package com.ise.shudi.leetcode022.merge.k.sorted.lists;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode left, ListNode right) {
						if (left == null) {
							return 1;
						} else if (right == null) {
							return -1;
						}
						return left.val - right.val;
					}
				});
		for(int i = 0; i < lists.size(); ++i) {
			if(lists.get(i) != null) {
				heap.add(lists.get(i));
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(!heap.isEmpty()) {
			ListNode head = heap.poll();
			tail.next = head;
			tail = head;
			if (head.next != null) {
				heap.add(head.next);
			}
		}
		return dummy.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
}