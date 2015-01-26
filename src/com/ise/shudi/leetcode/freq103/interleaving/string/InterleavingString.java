package com.ise.shudi.leetcode.freq103.interleaving.string;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "aaab";
		InterleavingString is = new InterleavingString();
		System.out.println(is.isInterleave(s1, s2, s3));
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() == 0) {
			return s2.equals(s3);
		}
		if(s2.length() == 0) {
			return s1.equals(s3);
		}
        if(s1.length() + s2.length() != s3.length()) {
        	return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[][] r = new boolean[m + 1][n + 1];
        r[0][0] = true;
        for(int i = 1; i <= m; ++i) {
        	r[i][0] = (r[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)); 
        }
        for(int j = 1; j <= n; ++j) {
        	r[0][j] = (r[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for(int i = 1; i <= m; ++i) {
        	for(int j = 1; j <= n; ++j) {
        		r[i][j] = (r[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) 
        				|| (r[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        	}
        }
        return r[m][n];
    }

}
