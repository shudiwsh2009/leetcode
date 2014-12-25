package com.ise.shudi.leetcode.freq047.n.queens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        List<Integer> cols = new ArrayList<Integer>();
        doSearch(result, n, cols);
        return result;
    }
	
	private void doSearch(List<String[]> result, int n, List<Integer> cols) {
		if(cols.size() == n) {
			result.add(drawChessBoard(cols));
			return;
		}
		for(int j = 0; j < n; ++j) {
			if(!isValid(j, cols)) {
				continue;
			}
			cols.add(j);
			doSearch(result, n, cols);
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
	
	private String[] drawChessBoard(List<Integer> cols) {
		String[] chess = new String[cols.size()];
		int n = cols.size();
		for(int i = 0; i < n; ++i) {
			chess[i] = "";
			for(int j = 0; j < n; ++j) {
				if(j == cols.get(i)) {
					chess[i] += "Q";
				} else {
					chess[i] += ".";
				}
			}
		}
		return chess;
	}

}
