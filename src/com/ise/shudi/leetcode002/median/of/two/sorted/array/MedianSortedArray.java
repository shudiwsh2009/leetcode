package com.ise.shudi.leetcode002.median.of.two.sorted.array;

public class MedianSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {};
		int[] B = { 1 };
		MedianSortedArray msa = new MedianSortedArray();
		System.out.println(msa.findMedianSortedArrays1(A, B));
	}

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {

		return 0.0;
	}

	// O(m+n)
	public double findMedianSortedArrays1(int A[], int B[]) {
		int m = A.length, n = B.length;
		int[] C = new int[m + n];
		int i = m + n;
		--m;
		--n;
		--i;
		while (m >= 0 && n >= 0) {
			if (A[m] >= B[n]) {
				C[i--] = A[m--];
			} else {
				C[i--] = B[n--];
			}
		}
		while (m >= 0) {
			C[i--] = A[m--];
		}
		while (n >= 0) {
			C[i--] = B[n--];
		}
		return (C[C.length / 2] + C[(C.length - 1) / 2]) / 2.0;
	}

}
