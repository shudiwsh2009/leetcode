package com.ise.shudi.leetcode.freq058.d20120430.partition.list;

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode leftHead = new ListNode(0), rightHead = new ListNode(0);
        ListNode left = leftHead, right = rightHead;
        while(head != null) {
        	if(head.val < x) {
        		left.next = new ListNode(head.val);
        		left = left.next;
        	} else {
        		right.next = new ListNode(head.val);
        		right = right.next;
        	}
        	head = head.next;
        }
        if(leftHead.next == null) {
        	return rightHead.next;
        } else if(rightHead.next == null) {
        	return leftHead.next;
        } else {
        	left.next = rightHead.next;
        	return leftHead.next;
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
