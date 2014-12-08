package com.ise.shudi.leetcode002.d20111101.add.two.numbers;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode r = atn.addTwoNumbers(l1, l2);
		while(r.next != null) {
			System.out.print(r.val + "->");
			r = r.next;
		}
		System.out.print(r.val);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode cur = result;
		int flag = 0;
		while(l1 != null && l2 != null) {
			int s = l1.val + l2.val + flag;
			flag = (s >= 10) ? 1 : 0;
			s = (s >= 10) ? (s - 10) : s;
			ListNode node = new ListNode(s);
			cur.next = node;
			cur = node;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null) {
			int s = l1.val + flag;
			flag = (s >= 10) ? 1 : 0;
			s = (s >= 10) ? (s - 10) : s;
			ListNode node = new ListNode(s);
			cur.next = node;
			cur = node;
			l1 = l1.next;
		}
		while(l2 != null) {
			int s = l2.val + flag;
			flag = (s >= 10) ? 1 : 0;
			s = (s >= 10) ? (s - 10) : s;
			ListNode node = new ListNode(s);
			cur.next = node;
			cur = node;
			l2 = l2.next;
		}
		if(flag != 0) {
			ListNode node = new ListNode(flag);
			cur.next = node;
		}
		return result.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}