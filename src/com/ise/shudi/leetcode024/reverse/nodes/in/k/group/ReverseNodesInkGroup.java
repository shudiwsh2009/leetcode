package com.ise.shudi.leetcode024.reverse.nodes.in.k.group;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInkGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		// head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);
		ListNode dummy = head;
		while (dummy != null) {
			System.out.print(dummy.val + " ");
			dummy = dummy.next;
		}
		System.out.println();
		ReverseNodesInkGroup rnikg = new ReverseNodesInkGroup();
		head = rnikg.reverseKGroup(head, 2);
		dummy = head;
		while (dummy != null) {
			System.out.print(dummy.val + " ");
			dummy = dummy.next;
		}
	}

	// O(1) space
	@SuppressWarnings("null")
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 0 || k == 1) {
			return head;
		}
		ListNode cur = head;
		int length = 0;
		while (cur != null) {
			cur = cur.next;
			++length;
		}
		int multi = length / k;
		if (multi == 0) {
			return head;
		}
		ListNode preTail = null, curHead = null, curTail = null;
		ListNode preNode = null, nextNode = null;
		cur = head;
		for (int j = 0; j < multi; ++j) {
			preNode = null;
			for (int i = 0; i < k; ++i) {
				if (cur != null) {
					nextNode = cur.next;
					cur.next = preNode;
					preNode = cur;
				}
				if (i == 0) {
					curTail = cur;
				}
				if (i == k - 1) {
					curHead = cur;
				}
				cur = nextNode;
			}
			if (preTail == null) {
				head = curHead;
			} else {
				preTail.next = curHead;
			}
			preTail = curTail;
		}
		curTail.next = cur;
		return head;
	}

	// O(k) space
	public ListNode reverseKGroup1(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode point = new ListNode(0);
		point.next = head;
		head = point;
		point = point.next;
		ListNode last = head;
		while (point != null) {
			List<ListNode> list = new ArrayList<ListNode>();
			for (int i = 0; i < k; ++i) {
				if (point != null) {
					list.add(point);
					point = point.next;
				}
			}
			if (list.size() == k) {
				for (int i = k - 1; i > 0; --i) {
					list.get(i).next = list.get(i - 1);
				}
				last.next = list.get(k - 1);
				last = list.get(0);
				last.next = point;
			} else {
				last.next = list.get(0);
			}
		}
		return head.next;
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