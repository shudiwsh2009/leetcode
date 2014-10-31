package com.ise.shudi.leetcode014.longest.common.prefix;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "aa", "a" };
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(strs));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		for (int i = 0; i < strs[0].length(); ++i) {
			for (int j = 1; j < strs.length; ++j) {
				if (i >= strs[j].length()
						|| strs[0].charAt(i) != strs[j].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
