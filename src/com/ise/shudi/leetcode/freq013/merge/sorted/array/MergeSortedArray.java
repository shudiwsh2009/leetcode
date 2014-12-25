package com.ise.shudi.leetcode.freq013.merge.sorted.array;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void merge(int A[], int m, int B[], int n) {
        while(m + n > 0 && n > 0) {
        	A[m + n - 1] = (m < 1 || A[m - 1] < B[n - 1]) ? B[(n--) - 1] : A[(m--) - 1];
        }
    }

}
