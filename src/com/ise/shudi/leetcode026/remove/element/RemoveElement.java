package com.ise.shudi.leetcode026.remove.element;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 2};
		RemoveElement re = new RemoveElement();
		int size = re.removeElement(A, 2);
		System.out.println(size);
		for (int i = 0; i < size; ++i) {
			System.out.print(A[i] + " ");
		}
	}

	public int removeElement(int[] A, int elem) {
		if(A == null || A.length == 0) {
			return 0;
		}
		int size = 0;
		for(int i = 0; i < A.length; ++i) {
			if(A[i] != elem) {
				A[size++] = A[i];
			}
		}
		return size;
	}
}
