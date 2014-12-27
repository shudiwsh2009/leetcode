package com.ise.shudi.leetcode.freq071.palindrome.partitioning.ii;

public class PalindromePartitioningII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		PalindromePartitioningII pp = new PalindromePartitioningII();
		System.out.println(pp.minCut(s));
	}
	
	public int minCut(String s) {
		if(s == null || s.length() <= 1) {
			return 0;
		}
        boolean[][] isPalindrome = getPalindrome(s);
        int[] cut = new int[s.length()];
        cut[0] = 0;
        for(int i = 1; i < s.length(); ++i) {
        	cut[i] = Integer.MAX_VALUE;
        	for(int j = 0; j <= i; ++j) {
        		if(isPalindrome[j][i]) {
        			if(j == 0) {
        				cut[i] = 0; 
        			} else {
            			cut[i] = Math.min(cut[i], cut[j - 1] + 1);
        			} 
        		}
        	}
        }
        return cut[s.length() - 1];
    }
	
	private boolean[][] getPalindrome(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); ++i) {
			isPalindrome[i][i] = true;
		}
		for(int i = 0; i < s.length() - 1; ++i) {
			isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
		}
		for(int length = 2; length < s.length(); ++length) {
			for(int i = 0; i + length < s.length(); ++i) {
				isPalindrome[i][i + length] = isPalindrome[i + 1][i + length - 1]
						&& (s.charAt(i) == s.charAt(i + length));
			}
		}
		return isPalindrome;
	}

}
