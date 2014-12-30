package com.ise.shudi.leetcode.freq090.jump.game;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;
        int i = 0, j = 1;
        for(i = 0; i < A.length; ++i) {
        	if(can[i] == false || i + A[i] < j) {
        		continue;
        	}
        	while(j < A.length && j <= i + A[i]) {
        		can[j++] = true;
        	}
        	if(j == A.length) {
        		return true;
        	}
        }
        return can[A.length - 1];
    }

}
