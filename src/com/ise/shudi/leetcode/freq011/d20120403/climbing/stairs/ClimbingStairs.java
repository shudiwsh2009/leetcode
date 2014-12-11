package com.ise.shudi.leetcode.freq011.d20120403.climbing.stairs;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int climbStairs(int n) {
		if(n == 1) {
			return 1;
		} else if(n == 2) {
			return 2;
		}
        int[] s = new int[n + 1];
        s[1] = 1;
        s[2] = 2;
        for(int i = 3; i <= n; ++i) {
        	s[i] = s[i - 1] + s[i - 2];
        }
        return s[n];
    }

}
