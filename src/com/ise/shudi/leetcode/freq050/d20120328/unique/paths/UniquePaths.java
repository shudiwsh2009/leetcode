package com.ise.shudi.leetcode.freq050.d20120328.unique.paths;

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePaths(int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(m == 1 || n == 1) {
			return 1;
		}
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(i == 0 && j == 0) {
        			continue;
        		} else if(i == 0) {
        			paths[i][j] = paths[i][j - 1];
        		} else if(j == 0) {
        			paths[i][j] = paths[i - 1][j];
        		} else {
        			paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
        		}
        	}
        }
        return paths[m - 1][n - 1];
    }

}
