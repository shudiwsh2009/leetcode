package com.ise.shudi.leetcode.freq048.d20120320.n.queens.ii;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(n));
	}
	
	public static int sum = 0;
	
	public int totalNQueens(int n) {
        List<Integer> cols = new ArrayList<Integer>();
        doSearch(n, cols);
        return sum;
    }
	
	private void doSearch(int n, List<Integer> cols) {
		if(cols.size() == n) {
			++sum;
			return;
		}
		for(int j = 0; j < n; ++j) {
			if(!isValid(j, cols)) {
				continue;
			}
			cols.add(j);
			doSearch(n, cols);
			cols.remove(cols.size() - 1);
		}
	}
	
	private boolean isValid(int j, List<Integer> cols) {
		int row = cols.size();
        for (int i = 0; i < row; i++) {
            // same column
            if (cols.get(i) == j)  {
                return false;
            }
            // left-top to right-bottom
            if (i - cols.get(i) == row - j) {
                return false;
            }
            // right-top to left-bottom
            if (i + cols.get(i) == row + j) {
                return false;
            }
        }
        return true;
	}

}
