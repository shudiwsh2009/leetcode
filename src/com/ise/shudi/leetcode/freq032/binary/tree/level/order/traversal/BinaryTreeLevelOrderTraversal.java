package com.ise.shudi.leetcode.freq032.binary.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        doLevel(root, 0, result);
        return result;
    }
	
	private void doLevel(TreeNode node, int level, List<List<Integer>> result) {
		if(node == null) {
			return;
		}
		if(result.size() < level + 1) {
			result.add(new ArrayList<Integer>());
		}
		result.get(level).add(node.val);
		doLevel(node.left, level + 1, result);
		doLevel(node.right, level + 1, result);
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
