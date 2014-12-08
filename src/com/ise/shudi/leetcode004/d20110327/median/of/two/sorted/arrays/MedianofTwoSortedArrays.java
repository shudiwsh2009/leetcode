package com.ise.shudi.leetcode004.d20110327.median.of.two.sorted.arrays;

/**
 * @author Shudi
 * @see http://blog.csdn.net/yutianzuijin/article/details/11499917/
 * 求第k小的数
 */
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 3, 5, 7, 9};
		int B[] = {2, 4, 6, 8, 10};
		MedianofTwoSortedArrays mtsa = new MedianofTwoSortedArrays();
		System.out.println(mtsa.findMedianSortedArrays(A, B));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m + n;
		if(total % 2 == 1) {
			return findKth(A, 0, m, B, 0, n, total / 2 + 1);
		} else {
			return (findKth(A, 0, m, B, 0, n, total / 2)
					+ findKth(A, 0, m, B, 0, n, total / 2 + 1)) / 2;
		}
    }
	
	private double findKth(int A[], int AStart, int ALength, int B[], int BStart, int Blength, int k) {
		if(ALength > Blength) {
			return findKth(B, BStart, Blength, A, AStart, ALength, k);
		}
		if(ALength == 0) {
			return B[BStart + k - 1];
		}
		if(k == 1) {
			return Math.min(A[AStart], B[BStart]);
		}
		int pa = Math.min(k / 2, ALength), pb = k - pa;
		if(A[AStart + pa - 1] < B[BStart + pb - 1]) {
			return findKth(A, AStart + pa, ALength - pa, B, BStart, Blength, k - pa);
		} else if(A[AStart + pa - 1] > B[BStart + pb - 1]) {
			return findKth(A, AStart, ALength, B, BStart + pb, Blength - pb, k - pb);
		} else {
			return A[AStart + pa - 1];
		}
	}
}
