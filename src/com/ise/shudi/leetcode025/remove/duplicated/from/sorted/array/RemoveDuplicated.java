package com.ise.shudi.leetcode025.remove.duplicated.from.sorted.array;

public class RemoveDuplicated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 2};
		RemoveDuplicated rd = new RemoveDuplicated();
		int size = rd.removeDuplicates(A);
		System.out.println(size);
		for (int i = 0; i < size; ++i) {
			System.out.print(A[i] + " ");
		}
	}

	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		int size = 0;
		for(int i = 0; i < A.length; ++i) {
			if(A[i] != A[size]) {
				A[++size] = A[i];
			}
		}
		return size + 1;
	}
}
