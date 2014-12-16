package com.ise.shudi.leetcode.freq031.d20120625.decode.ways;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numDecodings(String s) {
		int n = s.length();
		if(n == 0) {
			return 0;
		}
		int[] mem = new int[n + 1];
		mem[n] = 1;
		mem[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
		
		for(int i = n - 2; i >= 0; --i) {
			if(s.charAt(i) == '0') {
				continue;
			} else {
				mem[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) 
						? mem[i + 1] + mem[i + 2] : mem[i + 1];
			}
		}
		return mem[0];
    }

}
