package com.ise.shudi.leetcode003.longest.substring.without.repeating.characters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		LongestSubstring ls = new LongestSubstring();
		System.out.println(ls.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		int lastIndex = -1;
		int max = 0;
		Map<Character, Integer> hmCharIndex = new HashMap<Character, Integer>();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; ++i) {
			if (hmCharIndex.containsKey(cs[i])
					&& lastIndex < hmCharIndex.get(cs[i])) {
				lastIndex = hmCharIndex.get(cs[i]);
			}
			max = Math.max(max, i - lastIndex);
			hmCharIndex.put(cs[i], i);
		}
		return max;
	}
}
