package com.ise.shudi.leetcode011.container.with.most.water;

public class MostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
		int start = 0, end = height.length - 1;
		int max = Integer.MIN_VALUE;
		while(start < end) {
			int area = Math.min(height[start], height[end]) * (end - start);
			max = Math.max(max, area);
			if(height[start] >= height[end]) {
				--end;
			} else {
				++start;
			}
		}
		return max;
	}

}
