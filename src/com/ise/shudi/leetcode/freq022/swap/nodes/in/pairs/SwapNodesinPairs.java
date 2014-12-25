package com.ise.shudi.leetcode.freq022.swap.nodes.in.pairs;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		SwapNodesinPairs snp = new SwapNodesinPairs();
		head = snp.swapPairs(head);
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode preOdd = null;
        head = head.next;
        while(odd != null && even != null) {
        	odd.next = even.next;
        	even.next = odd;
        	if(preOdd != null) {
        		preOdd.next = even;
        	}
    		preOdd = odd;
        	if(odd.next == null || odd.next.next == null) {
        		return head;
        	} else {
        		odd = odd.next;
        		even = odd.next;
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