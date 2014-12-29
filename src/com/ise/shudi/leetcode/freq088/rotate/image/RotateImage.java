package com.ise.shudi.leetcode.freq088.rotate.image;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void rotate(int[][] matrix) {
		int n = matrix.length - 1;
		for(int i = 0; i <= n - i; i++){
            for(int j = i; j <= n - i - 1; j++)
            {
                int tmp = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = tmp;
            }
        }
    }

}
