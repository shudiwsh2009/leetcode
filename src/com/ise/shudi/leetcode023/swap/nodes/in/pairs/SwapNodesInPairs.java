package com.ise.shudi.leetcode023.swap.nodes.in.pairs;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
		ListNode dummy = head;
		while(dummy != null) {
			System.out.print(dummy.val + " ");
			dummy = dummy.next;
		}
		System.out.println();
		SwapNodesInPairs snip = new SwapNodesInPairs();
		head = snip.swapPairs(head);
		dummy = head;
		while(dummy != null) {
			System.out.print(dummy.val + " ");
			dummy = dummy.next;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		head = head.next;
		while(odd != null && odd.next != null) {
			odd.next = even.next;
			even.next = odd;
			odd = odd.next;
			if(odd != null && odd.next != null) {
				even.next.next = odd.next;
				even = even.next.next;
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