package com.ise.shudi.leetcode.freq012.d20120405.set.matrix.zeroes;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{0, 0, 0, 5},
				{4, 3, 1, 4},
				{0, 1, 1, 4},
				{1, 2, 1, 3},
				{0, 0, 1, 1}
		};
		SetMatrixZeroes smz = new SetMatrixZeroes();
		smz.setZeroes(matrix);
		for(int[] is : matrix) {
			for(int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
        	return ;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
            	col0 = 0;
            }
            for (int j = 1; j < n; j++){
            	if (matrix[i][j] == 0) {
                	matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
            	matrix[i][0] = 0;
            }
        }
    }

}
