package com.ise.shudi.leetcode.freq084.first.missing.positive;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 1};
		FirstMissingPositive fmp = new FirstMissingPositive();
		System.out.println(fmp.firstMissingPositive(A));
	}
	
	public int firstMissingPositive(int[] A) {
		if(A.length == 0) {
			return 1;
		}
        int deal = -1;
        for(int i = 0; i < A.length; ++i) {
        	if(A[i] > A.length || A[i] <= 0 || A[i] == i + 1) {
        		continue;
        	} else {
        		deal = A[A[i] - 1];
        		A[A[i] - 1] = A[i];
        		while(deal > 0 && deal < A.length) {
        			int tmp = A[deal - 1];
        			if(deal == tmp) {
        				deal = -1;
        				break;
        			} else {
        				A[deal - 1] = deal;
        				deal = tmp;
        			}
        		}
        	}
        }
        for(int i = 0; i < A.length; ++i) {
        	if(A[i] != i + 1) {
        		return i + 1;
        	}
        }
        return A.length + 1;
    }

}
