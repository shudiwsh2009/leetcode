package com.ise.shudi.leetcode.freq063.construct.binary.tree.from.inorder.and.postorder.traversal;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return doBuild(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
	
	public TreeNode doBuild(int[] inorder, int inLeft, int inRight,
			int[] postorder, int postLeft, int postRight) {
		if(inLeft > inRight) {
			return null;
		}
		if(inLeft == inRight) {
			return new TreeNode(inorder[inLeft]);
		}
		TreeNode root = new TreeNode(postorder[postRight]);
		int rootInPlace = 0;
		while(inorder[inLeft + rootInPlace] != postorder[postRight]) {
			++rootInPlace;
		}
		root.left = doBuild(inorder, inLeft, inLeft + rootInPlace - 1, postorder, postLeft, postLeft + rootInPlace - 1);
		root.right = doBuild(inorder, inLeft + rootInPlace + 1, inRight, postorder, postLeft + rootInPlace, postRight - 1);
		return root;
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