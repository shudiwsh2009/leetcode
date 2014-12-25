package com.ise.shudi.leetcode.freq049.maximum.subarray;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
        int[] subSum = new int[A.length];
        subSum[0] = A[0];
        int maxSum = subSum[0];
        for(int i = 1; i < A.length; ++i) {
        	subSum[i] = Math.max(subSum[i - 1] + A[i], A[i]);
        	maxSum = Math.max(maxSum, subSum[i]);
        }
        return maxSum;
    }

}
