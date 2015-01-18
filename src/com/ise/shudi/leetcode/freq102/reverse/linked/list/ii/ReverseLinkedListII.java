package com.ise.shudi.leetcode.freq102.reverse.linked.list.ii;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ReverseLinkedListII rllii = new ReverseLinkedListII();
		head = rllii.reverseBetween(head, 1, 5);
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m == n) {
			return head;
		}
        int count = 1;
        ListNode mPre = null, mCur = head, nCur = head, nNext = nCur.next;
        while(count < m && count < n) {
        	mPre = mCur;
        	mCur = mCur.next;
        	nCur = nNext;
        	nNext = nNext.next;
        	++count;
        }
        while(count < n) {
        	nCur = nNext;
        	nNext = nNext.next;
        	++count;
        }
        ListNode cur = mCur, pre = cur, next = mCur.next;
        while(cur != nCur) {
        	cur = next;
        	next = next.next;
        	cur.next = pre;
        	pre = cur;
        }
        mCur.next = nNext;
        if(mCur == head) {
        	return nCur;
        }
		mPre.next = nCur;
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