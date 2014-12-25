package com.ise.shudi.leetcode.freq046.wildcard.matching;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
		String p = "*aabb***aa**a******aa*";
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatch(s, p));
	}
	
	public boolean isMatch(String s, String p) {
		int si = 0, pi = 0, match = 0, starIdx = -1;
		while(si < s.length()) {
			if(pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
				++si;
				++pi;
			} else if(pi < p.length() && p.charAt(pi) == '*') {
				starIdx = pi;
				match = si;
				++pi;
			} else if(starIdx != -1) {
				pi = starIdx + 1;
				++match;
				si = match;
			} else {
				return false;
			}
		}
		while(pi < p.length() && p.charAt(pi) == '*') {
			++pi;
		}
		return (pi == p.length());
    }

}
