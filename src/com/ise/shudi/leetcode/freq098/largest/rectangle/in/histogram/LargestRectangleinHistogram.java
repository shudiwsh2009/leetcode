package com.ise.shudi.leetcode.freq098.largest.rectangle.in.histogram;

import java.util.Stack;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1, 2, 3, 4, 5};
		LargestRectangleinHistogram lrh = new LargestRectangleinHistogram();
		System.out.println(lrh.largestRectangleArea(height));
	}
	
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for(int i = 0; i <= height.length; ++i) {
			int curt = (i == height.length) ? -1 : height[i];
			while(!stack.isEmpty() && curt <= height[stack.peek()]) {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.push(i);
		}
		return max;
    }

}
