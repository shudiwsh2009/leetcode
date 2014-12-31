package com.ise.shudi.leetcode.freq091.spiral.matrix.ii;

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		SpiralMatrixII smii = new SpiralMatrixII();
		int[][] matrix = smii.generateMatrix(n);
		for(int[] is : matrix) {
			for(int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] generateMatrix(int n) {
		if(n == 0) {
			return new int[0][0];
		}
		int[][] matrix = new int[n][n];
		int i = 0, j = 0, cur = 1;
		matrix[i][j] = cur++;
		int direction = 1;
		while(cur <= n * n) {
			if(direction == 1) {
				if(j == n - 1 || matrix[i][j + 1] != 0) {
					direction = 2;
				} else {
					matrix[i][++j] = cur++;
				}
			} else if(direction == 2) {
				if(i == n - 1 || matrix[i + 1][j] != 0) {
					direction = 3;
				} else {
					matrix[++i][j] = cur++;
				}
			} else if(direction == 3) {
				if(j == 0 || matrix[i][j - 1] != 0) {
					direction = 4;
				} else {
					matrix[i][--j] = cur++;
				}
			} else if(direction == 4) {
				if(i == 0 || matrix[i - 1][j] != 0) {
					direction = 1;
				} else {
					matrix[--i][j] = cur++;
 				}
			}
		}
		return matrix;
    }

}
