package com.ise.shudi.leetcode.freq056.d20120422.remove.duplicates.from.sorted.list.ii;

public class RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(-1), pre = dummy;
        for (ListNode cur = head, next = head.next; cur != null; next = cur == null ? null : cur.next) {
            if (next == null || cur.val != next.val) {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            } else {
                cur = next.next;
                while (cur != null && cur.val == next.val) {
                    cur = cur.next;
                }
            }
        }
        pre.next = null;
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