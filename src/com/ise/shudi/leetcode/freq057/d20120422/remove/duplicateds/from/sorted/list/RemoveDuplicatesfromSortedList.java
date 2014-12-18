package com.ise.shudi.leetcode.freq057.d20120422.remove.duplicateds.from.sorted.list;

public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode cur = head;
        while(cur.next != null) {
        	if(cur.val == cur.next.val) {
        		cur.next = cur.next.next;
        	} else {
        		cur = cur.next;
        	}
        }
        return head;
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
