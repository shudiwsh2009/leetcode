package com.ise.shudi.leetcode.freq033.sum.root.to.left.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
        List<String> alStr = new ArrayList<String>();
        Stack<Integer> stack = new Stack<Integer>();
        doString(alStr, root, stack);
        int sum = 0;
        for(String s : alStr) {
        	sum += Integer.parseInt(s);
        }
        return sum;
    }
	
	private void doString(List<String> alStr, TreeNode node, Stack<Integer> stack) {
		if(node == null) {
			return;
		}
		stack.push(node.val);
		if(node.left == null && node.right == null) {
			String tmp = "";
			for(int i : stack) {
				tmp += i;
			}
			alStr.add(tmp);
		}
		if(node.left != null) {
			doString(alStr, node.left, stack);
		}
		if(node.right != null) {
			doString(alStr, node.right, stack);
		}
		stack.pop();
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
