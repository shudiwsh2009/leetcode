package com.ise.shudi.leetcode.freq085.trapping.rain.water;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int trap(int[] A) {
        if(A.length < 3) {
        	return 0;
        }
        int area = 0;
        int l = 0, r = A.length - 1;
        while(l < r && A[l] <= A[l + 1]) {
        	++l;
        }
        while(l < r && A[r] <= A[r - 1]) {
        	--r;
        }
        while(l < r) {
        	int left = A[l];
        	int right = A[r];
        	if(left <= right) {
        		while(l < r && left >= A[++l]) {
        			area += (left - A[l]);
        		}
        	} else {
        		while(l < r && A[--r] <= right) {
        			area += (right - A[r]);
        		}
        	}
        }
        return area;
    }

}
