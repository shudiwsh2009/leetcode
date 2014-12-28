package com.ise.shudi.leetcode.freq075.container.with.most.water;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = Integer.MIN_VALUE;
        while(i < j) {
        	area = Math.max(area, Math.min(height[j], height[i]) * (j - i));
        	if(height[i] > height[j]) {
        		--j;
        	} else {
        		++i;
        	}
        }
        return area;
    }
}
