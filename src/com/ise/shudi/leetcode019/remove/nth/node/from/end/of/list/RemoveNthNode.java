package com.ise.shudi.leetcode019.remove.nth.node.from.end.of.list;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(1) space
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < n; ++i) {
			fast = fast.next;
		}
		if (fast == null) {
			return slow.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public ListNode removeNthFromEnd1(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		Map<Integer, ListNode> hmNode = new HashMap<Integer, ListNode>();
		int i = 1;
		while (head != null) {
			hmNode.put(i++, head);
			head = head.next;
		}
		int index = hmNode.size() - n + 1;
		if (hmNode.size() == 1) {
			return null;
		} else if (index == 1) {
			return hmNode.get(2);
		} else if (index == hmNode.size()) {
			hmNode.get(index - 1).next = null;
			return hmNode.get(1);
		} else {
			hmNode.get(index - 1).next = hmNode.get(index + 1);
			return hmNode.get(1);
		}
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