package com.ise.shudi.leetcode.freq089.spiral.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		SpiralMatrix sm = new SpiralMatrix();
		List<Integer> result = sm.spiralOrder(matrix);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
        	return new ArrayList<Integer>();
        }
        int n = matrix[0].length;
        if(n == 0) {
        	return new ArrayList<Integer>();
        }
        int i = 0, j = 0, direction = 1;
        boolean[][] visited = new boolean[m][n];
        List<Integer> result = new ArrayList<Integer>();
        result.add(matrix[i][j]);
        visited[i][j] = true;
        while(result.size() < m * n) {
        	if(direction == 1) {
        		if(j == n - 1 || visited[i][j + 1] == true) {
        			direction = 2;
        		} else {
        			++j;
        			result.add(matrix[i][j]);
        			visited[i][j] = true;
        		}
        	} else if(direction == 2) {
        		if(i == m - 1 || visited[i + 1][j] == true) {
        			direction = 3;
        		} else {
        			++i;
        			result.add(matrix[i][j]);
        			visited[i][j] = true;
        		}
        	} else if(direction == 3) {
        		if(i == 0 || visited[i - 1][j] == true) {
        			direction = 4;
        		} else {
        			--i;
        			result.add(matrix[i][j]);
        			visited[i][j] = true;
        		}
        	} else if(direction == 4) {
        		if(j == 0 || visited[i][j - 1] == true) {
        			direction = 1;
        		} else {
        			--j;
        			result.add(matrix[i][j]);
        			visited[i][j] = true;
        		}
        	}
        }
        return result;
    }
	
}
