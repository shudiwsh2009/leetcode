package com.ise.shudi.leetcode.freq080.valid.sudoku;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
        for(int i = 0; i < 9; ++i) {
        	for(int j = 0; j < 9; ++j) {
        		if(board[i][j] != '.') {
        			int num = board[i][j] - '1';
        			if(row[i][num] == true) {
        				return false;
        			} else {
        				row[i][num] = true;
        			}
        			if(col[j][num] == true) {
        				return false;
        			} else {
        				col[j][num] = true;
        			}
        			if(box[i / 3 + j / 3 * 3][num] == true) {
        				return false;
        			} else {
        				box[i / 3 + j / 3 * 3][num] = true;
        			}
        		}
        	}        	
        }
        return true;
    }

}
