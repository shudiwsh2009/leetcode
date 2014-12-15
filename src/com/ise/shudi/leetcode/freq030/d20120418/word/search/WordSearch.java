package com.ise.shudi.leetcode.freq030.d20120418.word.search;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
				};
		String word = "ABCCED";
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(board, word));
	}
	
	public boolean exist(char[][] board, String word) {
		if(board.length == 0 || board[0].length == 0) {
			return false;
		}
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] cs = word.toCharArray();
        for(int i = 0; i < board.length; ++i) {
        	for(int j = 0; j < board[0].length; ++j) {
        		if(perSearch(board, cs, 0, used, i, j)) {
        			return true;
        		}
        	}
        }
        return false;
    }
	
	private boolean perSearch(char[][] board, char[] cs, int index, boolean[][] used, int i, int j) {
		if(index == cs.length - 1 && board[i][j] == cs[index] && used[i][j] == false) {
			return true;
		}
		if(used[i][j] == true || board[i][j] != cs[index]) {
			return false;
		}
		used[i][j] = true;
		if(i > 0) {
			if(perSearch(board, cs, index + 1, used, i - 1, j)) {
				return true;
			}
		}
		if(i < board.length - 1) {
			if(perSearch(board, cs, index + 1, used, i + 1, j)) {
				return true;
			}
		}
		if(j > 0) {
			if(perSearch(board, cs, index + 1, used, i, j - 1)) {
				return true;
			}
		}
		if(j < board[0].length - 1) {
			if(perSearch(board, cs, index + 1, used, i, j + 1)) {
				return true;
			}
		}
		used[i][j] = false;
		return false;
	}

}
