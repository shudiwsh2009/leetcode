package com.ise.shudi.leetcode.freq039.d20120127.remove.nth.node.from.end.of.list;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
        	return head;
        } else if(head.next == null && n == 1) {
        	return null;
        }
        ListNode tail = head, p = head;
        while(n > 0) {
        	p = p.next;
        	--n;
        }
        if(p == null) {
        	return head.next;
        }
        while(p.next != null) {
        	tail = tail.next;
        	p = p.next;
        }
        tail.next = tail.next.next;
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
