package com.ise.shudi.leetcode.freq096.minimum.windows.substring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String minWindow(String S, String T) {
        Map<Character, Integer> hmIndex = new HashMap<Character, Integer>();
        for(char c : T.toCharArray()) {
        	hmIndex.put(c, -1);
        }
        for(int i = 0; i < S.length(); ++i) {
        	if(hmIndex.containsKey(S.charAt(i))) {
        		hmIndex.put(S.charAt(i), i);
        	}
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i : hmIndex.values()) {
        	if(i == -1) {
        		return "";
        	}
        	max = Math.max(max, i);
        	min = Math.min(min, i);
        }
        return S.substring(min, max + 1);
    }

}
