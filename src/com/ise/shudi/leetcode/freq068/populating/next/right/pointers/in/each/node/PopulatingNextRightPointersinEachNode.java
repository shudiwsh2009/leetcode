package com.ise.shudi.leetcode.freq068.populating.next.right.pointers.in.each.node;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root, lastLever = root;
        while(cur != null) {
        	if(cur.left != null) {
        		cur.left.next = cur.right;
        	}
        	if(cur.next != null && cur.next.left != null) {
        		cur.right.next = cur.next.left;
        		cur = cur.next;
        	} else {
        		cur = lastLever.left;
        		lastLever = cur;
        	}
        }
    }

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	
	public TreeLinkNode(int x) {
		val = x;
	}
}