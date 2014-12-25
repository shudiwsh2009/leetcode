package com.ise.shudi.leetcode.freq021.merge.k.sorted.lists;

import java.util.List;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if(lists.size() == 0) {
			return null;
		} else if(lists.size() == 1) {
			return lists.get(0);
		} else if(lists.size() == 2) {
			return mergeTwoList(lists.get(0), lists.get(1));
		}
		return mergeTwoList(mergeKLists(lists.subList(0, lists.size() / 2)), 
				mergeKLists(lists.subList(lists.size() / 2, lists.size())));
    }
	
	private ListNode mergeTwoList(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = new ListNode(l1.val);
				l1 = l1.next;
				cur = cur.next;
			} else {
				cur.next = new ListNode(l2.val);
				l2 = l2.next;
				cur = cur.next;
			}
		}
		while(l1 != null) {
			cur.next = new ListNode(l1.val);
			l1 = l1.next;
			cur = cur.next;
		}
		while(l2 != null) {
			cur.next = new ListNode(l2.val);
			l2 = l2.next;
			cur = cur.next;
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