package com.ise.shudi.leetcode.freq062.construct.binary.tree.from.preorder.and.inorder.traversal;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
	
	private TreeNode doBuild(int[] preorder, int preLeft, int preRight,
			int[] inorder, int inLeft, int inRight) {
		if(preLeft > preRight){
			return null;
		}
		if(preLeft == preRight) {
			return new TreeNode(preorder[preLeft]);
		}
		TreeNode root = new TreeNode(preorder[preLeft]);
		int rootInPlace = 0;
		while(inorder[inLeft + rootInPlace] != preorder[preLeft]) {
			++rootInPlace;
		}
		root.left = doBuild(preorder, preLeft + 1, preLeft + rootInPlace, inorder, inLeft, inLeft + rootInPlace - 1);
		root.right = doBuild(preorder, preLeft + rootInPlace + 1, preRight, inorder, inLeft + rootInPlace + 1, inRight);
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