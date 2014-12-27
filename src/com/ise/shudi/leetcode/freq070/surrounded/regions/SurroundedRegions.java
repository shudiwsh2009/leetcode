package com.ise.shudi.leetcode.freq070.surrounded.regions;

import java.util.Stack;

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] board = {
//				{'X', 'X', 'X', 'X'},
//				{'X', 'O', 'O', 'X'},
//				{'X', 'X', 'O', 'X'},
//				{'X', 'O', 'X', 'X'}};
		char[][] board = {{'O'}};
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		for(int i = 0; i < board.length; ++i) {
			for(int j = 0; j < board[0].length; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void solve(char[][] board) {
		int m = board.length;
		if(m == 0) {
			return;
		}
		int n = board[0].length;
		if(n == 0) {
			return;
		}
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
					Stack<Pair> stack = new Stack<Pair>();
					stack.push(new Pair(i, j));
					while(!stack.isEmpty()) {
						Pair p = stack.pop();
						if(p.x < 0 || p.y < 0 || p.x >= m || p.y >= n || board[p.x][p.y] != 'O') {
							continue;
						}
						board[p.x][p.y] = 'N';
						stack.push(new Pair(p.x - 1, p.y));
						stack.push(new Pair(p.x + 1, p.y));
						stack.push(new Pair(p.x, p.y - 1));
						stack.push(new Pair(p.x, p.y + 1));
					}
				}
			}
		}
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X'; 
				} else if(board[i][j] == 'N') {
					board[i][j] = 'O'; 
				}
			}
		}
    }

}

class Pair {
	int x;
	int y;
	public Pair(int _x, int _y) {
		x = _x;
		y = _y;
	}
}
