package com.ise.shudi.leetcode.freq051.d20120328.unique.paths.ii;

public class UniquePathsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) {
        	return 0;
        }
        int n = obstacleGrid[0].length;
        if(n == 0) {
        	return 0;
        }
        int[][] paths = new int[m][n];
        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 0; i < m; ++i) {
        	for(int j = 0; j < n; ++j) {
        		if(obstacleGrid[i][j] == 1) {
        			paths[i][j] = 0; 
        		} else if(i == 0 && j == 0) {
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
