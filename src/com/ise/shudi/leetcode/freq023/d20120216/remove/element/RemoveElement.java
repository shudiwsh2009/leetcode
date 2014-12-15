package com.ise.shudi.leetcode.freq023.d20120216.remove.element;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0) {
        	return 0;
        }
        int head = 0, tail = -1;
        while(head < A.length) {
        	if(A[head] == elem) {
        		++head;
        	} else {
        		A[++tail] = A[head++];
        	}
        }
        return tail + 1;
    }

}
