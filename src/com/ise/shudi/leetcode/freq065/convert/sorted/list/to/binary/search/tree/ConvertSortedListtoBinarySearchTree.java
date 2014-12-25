package com.ise.shudi.leetcode.freq065.convert.sorted.list.to.binary.search.tree;

public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private ListNode cur;
	
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        return generate(count(head));
    }
    
    private TreeNode generate(int n){
        if (0 == n)
            return null;
        TreeNode node = new TreeNode(0);
        node.left = generate(n / 2);
        node.val = cur.val;
        cur = cur.next;
        node.right = generate(n - n / 2 - 1);
        return node;
    }
    
    private int count(ListNode h){
        int size = 0;
        while (h != null){
            ++size;
            h = h.next;
        }
        return size;
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

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x) {
		val = x;
	}
}