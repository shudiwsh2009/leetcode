package com.ise.shudi.leetcode004.add.two.numbers;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return add(l1, l2, 0);
	}

	public ListNode add(ListNode l1, ListNode l2, int add) {
		ListNode node = new ListNode(0);
		if (l1 == null && l2 == null) {
			if (add == 0) {
				return null;
			} else {
				return new ListNode(1);
			}
		} else if (l1 == null) {
			int val = l2.val + add;
			node.val = val >= 10 ? val - 10 : val;
			node.next = add(l1, l2.next, val >= 10 ? 1 : 0);
			return node;
		} else if (l2 == null) {
			int val = l1.val + add;
			node.val = val >= 10 ? val - 10 : val;
			node.next = add(l1.next, l2, val >= 10 ? 1 : 0);
			return node;
		} else {
			int val = l1.val + l2.val + add;
			node.val = val >= 10 ? val - 10 : val;
			node.next = add(l1.next, l2.next, val >= 10 ? 1 : 0);
			return node;
		}
	}
}
