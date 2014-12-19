package com.ise.shudi.leetcode.freq060.d20120827.binary.tree.inorder.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Iteratively
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) {
			return result;
		}
		TreeNode node = root;
		while(!stack.isEmpty() || node != null) {
			if(node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				result.add(node.val);
				node = node.right;
			}
		}
		return result;
	}
	
	// Recursively
	public List<Integer> inorderTraversal1(TreeNode root) {
        if(root == null) {
        	return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        doTraversal(root, result);
        return result;
    }
	
	private void doTraversal(TreeNode node, List<Integer> result) {
		if(node.left != null) {
			doTraversal(node.left, result);
		}
		result.add(node.val);
		if(node.right != null) {
			doTraversal(node.right, result);
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
