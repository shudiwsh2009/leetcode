package com.ise.shudi.leetcode.freq078.next.permutation;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void nextPermutation(int[] num) {
		int i = num.length - 1, j = num.length - 1;
        for(i = num.length - 1; i > 0; --i) {
        	if(num[i] > num[i - 1]) {
        		int k = num.length - 1;
        		while(num[k] <= num[i - 1]) {
        			--k;
        		}
        		int tmp = num[k];
        		num[k] = num[i - 1];
        		num[i - 1] = tmp;
        		break;
        	}
        }
        while(i <= j) {
        	int tmp = num[i];
        	num[i] = num[j];
        	num[j] = tmp;
        	++i;
        	--j;
        }
    }

}
