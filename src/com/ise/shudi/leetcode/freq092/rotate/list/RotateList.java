package com.ise.shudi.leetcode.freq092.rotate.list;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		int length = 1;
		while(fast.next != null) {
			fast = fast.next;
			++length;
		}
		fast.next = head;
		for(int i = 0; i < length - n % length - 1; ++i) {
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;
		return fast;
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