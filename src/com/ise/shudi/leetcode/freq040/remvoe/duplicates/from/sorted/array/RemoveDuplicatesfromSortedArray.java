package com.ise.shudi.leetcode.freq040.remvoe.duplicates.from.sorted.array;

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int removeDuplicates(int[] A) {
		if(A.length == 0 || A.length == 1) {
			return A.length;
		}
        int length = 0, head = 1;
        while(head < A.length) {
        	if(A[head] != A[length]) {
        		A[++length] = A[head++];
        	} else {
        		++head;
        	}
        }
        return length + 1;
    }

}
