package com.ise.shudi.leetcode.freq061.d20120928.binary.tree.zigzag.level.order.traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
        	return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
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