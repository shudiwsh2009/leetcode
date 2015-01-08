package com.ise.shudi.leetcode.freq096.minimum.windows.substring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String minWindow(String S, String T) {
		int start = 0, end = S.length() - 1, length = S.length();
		Map<Character, Integer> hmCharNeeded = new HashMap<Character, Integer>();
		for(char c : T.toCharArray()) {
			if(!hmCharNeeded.containsKey(c)) {
				hmCharNeeded.put(c, 1);
			} else {
				hmCharNeeded.put(c, hmCharNeeded.get(c) + 1);
			}
		}
		int count = T.length();
		int j = 0;
		for(int i = 0; i < S.length(); ++i) {
			char c = S.charAt(i);
			if(hmCharNeeded.containsKey(c)) {
				if(hmCharNeeded.get(c) > 0) {
					--count;
				}
				hmCharNeeded.put(c, hmCharNeeded.get(c) - 1);
			}
			if(count == 0) {
				char cj = S.charAt(j);
				while(!hmCharNeeded.containsKey(cj)
						|| hmCharNeeded.get(cj) < 0) {
					if(hmCharNeeded.containsKey(cj)) {
						hmCharNeeded.put(cj, hmCharNeeded.get(cj) + 1);
					}
					++j;
					cj = S.charAt(j);
				}
				if(length > i - j + 1) {
					start = j;
					end = i;
					length = i - j + 1;
				}
			}
		}
		if(count != 0) {
			return "";
		}
		return S.substring(start, end + 1);
    }

}
