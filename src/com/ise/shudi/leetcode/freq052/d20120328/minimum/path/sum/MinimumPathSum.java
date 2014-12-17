package com.ise.shudi.leetcode.freq052.d20120328.minimum.path.sum;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
        	return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(i == 0 && j == 0) {
        			path[i][j] = grid[i][j];
        		} else if(i == 0) {
        			path[i][j] = path[i][j - 1] + grid[i][j];
        		} else if(j == 0) {
        			path[i][j] = path[i - 1][j] + grid[i][j];
        		} else {
        			path[i][j] = Math.min(path[i - 1][j] + grid[i][j], path[i][j - 1] + grid[i][j]);
        		}
        	}
        }
        return path[m - 1][n - 1];
    }

}
