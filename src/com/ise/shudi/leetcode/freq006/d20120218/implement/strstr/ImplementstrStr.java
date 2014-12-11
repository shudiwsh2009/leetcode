package com.ise.shudi.leetcode.freq006.d20120218.implement.strstr;

import java.util.HashMap;
import java.util.Map;

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "ababcde";
		String needle = "abcd";
		ImplementstrStr is = new ImplementstrStr();
		System.out.println(is.strStr(haystack, needle));
	}
	
	// Sunday Algorithm
	public int strStr(String haystack, String needle) {
		if(haystack.length() < needle.length()) {
			return -1;
		}
		char[] text = haystack.toCharArray();
		char[] pattern = needle.toCharArray();
        Map<Character, Integer> hmPattern = new HashMap<Character, Integer>();
        for(int i = 0; i < pattern.length; ++i) {
        	hmPattern.put(pattern[i], i);
        }
        int i = 0, j = 0;
        int prevI = i;
        while(i < haystack.length() && j < needle.length()) {
        	if(text[i] == pattern[j]) {
        		++i;
        		++j;
        	} else {
        		int k = prevI + pattern.length;
        		while(k < text.length) {
        			if(hmPattern.containsKey(text[k])) {
        				prevI += (k - prevI - hmPattern.get(text[k]));
        				i = prevI;
        				j = 0;
        				break;
        			} else {
        				++k;
        			}
        		}
        		if(k >= text.length) {
        			return -1;
        		}
        	}
        }
        if(j == needle.length()) {
        	return prevI;
        } else {
        	return -1;
        }
    }

}
