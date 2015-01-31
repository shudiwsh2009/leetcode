package com.ise.shudi.leetcode.freq104.recover.binary.search.tree;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
		rbst.recoverTree(root);
		System.out.println(root.val + " " + root.left.val);
	}
	
	private TreeNode firstNode;
	private TreeNode secondNode;
	private TreeNode firstSuccNode;
	private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		if(root == null) {
			return;
		}
		doTraverse(root);
		int tmp = firstNode.val;
		if(secondNode == null) {
			firstNode.val = firstSuccNode.val;
			firstSuccNode.val = tmp;
		} else {
			firstNode.val = secondNode.val;
			secondNode.val = tmp;
		}
    }
	
	private void doTraverse(TreeNode root) {
		if(root == null) {
			return;
		}
		doTraverse(root.left);
		if(preNode.val >= root.val) {
			if(firstNode == null) {
				firstNode = preNode;
				firstSuccNode = root;
			} else {
				if(preNode == firstSuccNode) {
					secondNode = root;
				} else if(preNode.val >= firstSuccNode.val) {
					secondNode = root;
				} else {
					secondNode = preNode;
				}
			}
		}
		preNode = root;
		doTraverse(root.right);
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