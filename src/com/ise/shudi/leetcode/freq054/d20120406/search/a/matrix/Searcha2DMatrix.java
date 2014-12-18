package com.ise.shudi.leetcode.freq054.d20120406.search.a.matrix;

public class Searcha2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		int target = 23;
		Searcha2DMatrix sm = new Searcha2DMatrix();
		System.out.println(sm.searchMatrix(matrix, target));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) {
        	return false;
        }
        int n = matrix[0].length;
        if(n == 0) {
        	return false;
        }
        int rowI = 0, rowJ = m - 1, row = 0;
        while(rowI <= rowJ) {
        	int mid = rowI + ((rowJ - rowI) >> 1);
        	if((mid != m - 1 && matrix[mid][0] <= target && matrix[mid + 1][0] > target)
        			|| (mid == m -1 && matrix[mid][0] <= target)) {
        		row = mid;
        		break;
        	} else if(matrix[mid][0] < target) {
        		rowI = mid + 1;
        	} else {
        		rowJ = mid - 1;
        	}
        }
        int colI = 0, colJ = n - 1;
        while(colI <= colJ) {
        	int mid = colI + ((colJ - colI) >> 1);
        	if(matrix[row][mid] == target) {
        		return true;
        	} else if(matrix[row][mid] < target) {
        		colI = mid + 1;
        	} else {
        		colJ = mid - 1;
        	}
        }
        return false;
    }

}
