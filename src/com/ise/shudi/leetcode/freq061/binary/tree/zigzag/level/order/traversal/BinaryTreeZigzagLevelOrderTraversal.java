package com.ise.shudi.leetcode.freq061.binary.tree.zigzag.level.order.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		BinaryTreeZigzagLevelOrderTraversal btt = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> result = btt.zigzagLevelOrder(root);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int currentLevel = 1;
        int nextLevel = 0;
        boolean reverse = false;
        List<Integer> current = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	current.add(node.val);
        	--currentLevel;
        	if(node.left != null) {
        		queue.offer(node.left);
        		++nextLevel;
        	}
        	if(node.right != null) {
        		queue.offer(node.right);
        		++nextLevel;
        	}
        	if(currentLevel == 0) {
        		if(reverse == true) {
        			Collections.reverse(current);
        		}
        		result.add(new ArrayList<Integer>(current));
        		currentLevel = nextLevel;
        		nextLevel = 0;
        		reverse = !reverse;
        		current.clear();
        	}
        }
        return result;
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