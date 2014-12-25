package com.ise.shudi.leetcode.freq095.d20120408.sort.colors;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 0};
		SortColors sc = new SortColors();
		sc.sortColors(A);
		for(int i : A) {
			System.out.print(i + " ");
		}
	}
	
	public void sortColors(int[] A) {
        if(A == null || A.length <= 1) {
        	return;
        }
        int i = 0, j = A.length - 1;
        int left = i;
        while(i <= j) {
        	if(A[i] == 0) {
        		swap(A, i, left);
        		++i;
        		++left;
        	} else if(A[i] == 1) {
        		++i;
        	} else if(A[i] == 2) {
        		swap(A, i, j);
        		--j;
        	}
        }
    }
	
	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

}
