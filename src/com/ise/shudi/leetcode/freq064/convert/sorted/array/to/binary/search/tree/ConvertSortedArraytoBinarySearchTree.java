package com.ise.shudi.leetcode.freq064.convert.sorted.array.to.binary.search.tree;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedArrayToBST(int[] num) {
        return doConvert(num, 0, num.length - 1);
    }
	
	public TreeNode doConvert(int[] num, int left, int right) {
		if(left > right) {
			return null;
		}
		if(left == right) {
			return new TreeNode(num[left]);
		}
		int mid = left + ((right - left) >> 1);
		TreeNode root = new TreeNode(num[mid]);
		root.left = doConvert(num, left, mid - 1);
		root.right = doConvert(num, mid + 1, right);
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