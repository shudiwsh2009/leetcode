package com.ise.shudi.leetcode.freq086.jump.game.ii;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5};
		JumpGameII jgii = new JumpGameII();
		System.out.println(jgii.jump(A));
	}
	
	public int jump(int[] A) {
		int[] step = new int[A.length];
		step[0] = 0;
		for(int i = 1; i < A.length; ++i) {
			step[i] = Integer.MAX_VALUE;
			for(int j = 0; j < i; ++j) {
				if(step[j] != Integer.MAX_VALUE && j + A[j] >= i) {
					step[i] = step[j] + 1;
					break;
				}
			}
		}
		return step[A.length - 1];
    }

}
