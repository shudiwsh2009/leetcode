package com.ise.shudi.leetcode.freq025.d20120319.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> anagrams(String[] strs) {
        Map<String, Integer> hmSortedString = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < strs.length; ++i) {
        	String s = strs[i];
        	char[] cs = s.toCharArray();
        	Arrays.sort(cs);
        	String tmp = new String(cs);
        	if(hmSortedString.containsKey(tmp)) {
        		if(hmSortedString.get(tmp) == -1) {
        			result.add(s);
        		} else {
        			result.add(strs[hmSortedString.get(tmp)]);
        			result.add(s);
        			hmSortedString.put(tmp, -1);
        		}
        	} else {
        		hmSortedString.put(tmp, i);
        	}
        }
        return result;
    }

}
