package com.ise.shudi.leetcode.freq067.flatten.binary.tree.to.linked.list;

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right= new TreeNode(5);
		root.right.right = new TreeNode(6);
		FlattenBinaryTreetoLinkedList fbt = new FlattenBinaryTreetoLinkedList();
		fbt.flatten(root);
		while(root != null) {
			System.out.print(root.val + "->");
			root = root.right;
		}
	}
	
	public void flatten(TreeNode root) {
		TreeNode cur = root;
		while(cur != null) {
			if(cur.left != null) {
				TreeNode pre = cur.left;
				while(pre.right != null) {
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
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