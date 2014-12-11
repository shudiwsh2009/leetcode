package com.ise.shudi.leetcode.freq005.d20120330.merge.two.sorted.lists;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		cur.next = new ListNode(l1.val);
        		l1 = l1.next;
        	} else {
        		cur.next = new ListNode(l2.val);
        		l2 = l2.next;
        	}
        	cur = cur.next;
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
