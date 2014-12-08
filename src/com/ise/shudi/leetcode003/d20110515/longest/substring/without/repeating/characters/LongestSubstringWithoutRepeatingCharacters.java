package com.ise.shudi.leetcode003.d20110515.longest.substring.without.repeating.characters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcab";
		LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(lswrc.lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
		char[] cs = s.toCharArray();
		Map<Character, Integer> hmCharIndex = new HashMap<Character, Integer>();
		int lastIndex = -1;
		int max = 0;
		for(int i = 0; i < cs.length; ++i) {
			if(hmCharIndex.containsKey(cs[i]) && lastIndex < hmCharIndex.get(cs[i])) {
				lastIndex = hmCharIndex.get(cs[i]);
				hmCharIndex.put(cs[i], i);
			} else {
				max = Math.max(max, i - lastIndex);
				hmCharIndex.put(cs[i], i);
			}
		}
		return max;
    }

}
