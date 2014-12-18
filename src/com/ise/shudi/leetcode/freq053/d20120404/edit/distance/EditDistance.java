package com.ise.shudi.leetcode.freq053.d20120404.edit.distance;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "a";
		String word2 = "ab";
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance(word1, word2));
	}
	
	public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(m == 0) {
        	return n;
        }
        if(n == 0) {
        	return m;
        }
        int[][] edit = new int[m + 1][n + 1];
        for(int i = 0; i <= m; ++i) {
        	edit[i][0] = i;
        }
        for(int j = 0; j <= n; ++j) {
        	edit[0][j] = j;
        }
        for(int i = 1; i <= m; ++i) {
        	for(int j = 1; j <= n; ++j) {
        		int cost = (word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1;
        		edit[i][j] = Math.min(Math.min(edit[i - 1][j] + 1, edit[i][j - 1] + 1), 
        				edit[i - 1][j - 1] + cost);
        	}
        }
        return edit[m][n];
    }

}
