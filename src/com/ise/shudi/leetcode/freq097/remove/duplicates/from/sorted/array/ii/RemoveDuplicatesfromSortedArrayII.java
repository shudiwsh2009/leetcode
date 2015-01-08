package com.ise.shudi.leetcode.freq097.remove.duplicates.from.sorted.array.ii;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1, 1, 2, 2, 3};
		RemoveDuplicatesfromSortedArrayII rd = new RemoveDuplicatesfromSortedArrayII();
		int length = rd.removeDuplicates(A);
		for(int i = 0; i < length; ++i) {
			System.out.print(A[i] + " ");
		}
	}
	
	public int removeDuplicates(int[] A) {
        if(A.length < 3) {
        	return A.length;
        }
        int count = 0;
        int idx = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[idx] == A[i]) {
                count++;
            } else {
            	count = 0;
            }
            if(count < 2) {
            	++idx;
            }
            A[idx] = A[i];
        }
        return idx + 1;
    }

}
