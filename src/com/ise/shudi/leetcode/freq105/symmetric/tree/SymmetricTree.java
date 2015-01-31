package com.ise.shudi.leetcode.freq105.symmetric.tree;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSymmetric(TreeNode root) {
        if(root == null) {
        	return true;
        }
        if(root.left == null && root.right == null) {
        	return true;
        }
        return doIsSymmetric(root.left, root.right);
    }
	
	public boolean doIsSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}
		if(left == null || right == null || left.val != right.val) {
			return false;
		}
		if(!doIsSymmetric(left.left, right.right)) {
			return false;
		}
		if(!doIsSymmetric(left.right, right.left)) {
			return false;
		}
		return true;
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