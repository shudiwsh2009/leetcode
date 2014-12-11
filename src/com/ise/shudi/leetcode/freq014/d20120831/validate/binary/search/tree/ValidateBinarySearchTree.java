package com.ise.shudi.leetcode.freq014.d20120831.validate.binary.search.tree;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidBST(TreeNode root) {
        if(root == null) {
        	return true;
        }
        if(root.left == null && root.right == null) {
        	return true;
        }
        return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	private boolean isValidNode(TreeNode node, int min, int max) {
		if(node == null) {
			return true;
		}
		if(node.val > max || node.val < min) {
			return false;
		}
		if((node.val == Integer.MAX_VALUE && node.right != null)
				|| (node.val == Integer.MIN_VALUE && node.left != null)) {
			return false;
		}
		return isValidNode(node.left, min, node.val - 1) && isValidNode(node.right, node.val + 1, max);
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