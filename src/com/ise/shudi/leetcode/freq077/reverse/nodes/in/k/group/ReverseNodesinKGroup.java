package com.ise.shudi.leetcode.freq077.reverse.nodes.in.k.group;

public class ReverseNodesinKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 0 || k == 1) {
			return head;
		}
		ListNode cur = head;
		int length = 0;
		while(cur != null) {
			++length;
			cur = cur.next;
		}
		int group = length / k;
		if(group == 0) {
			return head;
		}
		ListNode preTail = null, curTail = null, curHead = null;
		ListNode preNode = null, nextNode = null;
		cur = head;
		for(int i = 0; i < group; ++i) {
			for(int j = 0; j < k; ++j) {
				if(cur != null) {
					nextNode = cur.next;
					cur.next = preNode;
					preNode = cur;
				}
				if(j == 0) {
					curTail = cur;
				} else if(j == k - 1) {
					curHead = cur;
				}
				cur = nextNode;
			}
			if(preTail == null) {
				head = curHead;
				preTail = curTail;
			} else {
				preTail.next = curHead;
				preTail = curTail;
			}
		}
		curTail.next = cur;
		return head;
    }

}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int x){
		val = x;
		next = null;
	}
}