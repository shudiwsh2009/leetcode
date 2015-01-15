package com.ise.shudi.leetcode.freq099.scramble.string;

import java.util.Arrays;

public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
        	return false;
        }
        if(s1.length() == 0 || s1.equals(s2)) {
        	return true;
        }
        if(!stringSort(s1).equals(stringSort(s2))) {
        	return false;
        }
        for(int i = 1; i < s1.length(); ++i) {
        	String s11 = s1.substring(0, i);
        	String s12 = s1.substring(i);
        	String s21 = s2.substring(0, i);
        	String s22 = s2.substring(i);
        	String s31 = s2.substring(s1.length() - i);
        	String s32 = s2.substring(0, s1.length() - i);
        	if((isScramble(s11, s21) && isScramble(s12, s22))
        			|| (isScramble(s11, s31) && isScramble(s12, s32))) {
        		return true;
        	}
        }
        return false;
    }
	
	private String stringSort(String s) {
		char[] cs = s.toCharArray(); 
		Arrays.sort(cs);
		return new String(cs);
	}

}
