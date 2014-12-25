package com.ise.shudi.leetcode.freq066.path.sum;

import java.util.Stack;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		int sum = -5;
		PathSum ps = new PathSum();
		System.out.println(ps.hasPathSum(root, sum));
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		if(root.left == null && root.right == null) {
			return root.val == sum;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null) {
        	return false;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        return doSum(root, stack, sum, root.val);
    }
	
	private boolean doSum(TreeNode node, Stack<TreeNode> stack, int sum, int current) {
		if(node.left == null && node.right == null) {
			if(sum == current) {
				return true;
			} else {
				return false;
			}
		}
		if(node.left != null) {
			stack.push(node.left);
			if(doSum(node.left, stack, sum, current + node.left.val)) {
				return true;
			}
			stack.pop();
		}
		if(node.right != null) {
			stack.push(node.right);
			if(doSum(node.right, stack, sum, current + node.right.val)) {
				return true;
			}
			stack.pop();
		}
		return false;
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