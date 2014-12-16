package com.ise.shudi.leetcode.freq037.d20120108.regular.expression.matching;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		String p = "c*a*b";
		RegularExpressionMatching rem = new RegularExpressionMatching();
		System.out.println(rem.isMatch(s, p));
	}
	
	public boolean isMatch(String s, String p) {
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();
		int si = 0, pi = 0;
		return doMatch(cs, cp, si, pi);
	}

	private boolean doMatch(char[] cs, char[] cp, int si, int pi) {
		if (pi >= cp.length) {
			return (si >= cs.length);
		}
		if (pi + 1 >= cp.length || cp[pi + 1] != '*') {
			if ((pi < cp.length && si < cs.length)
					&& (cp[pi] == cs[si] || (cp[pi] == '.' && si < cs.length))) {
				return doMatch(cs, cp, si + 1, pi + 1);
			} else {
				return false;
			}
		} else {
			while ((pi < cp.length && si < cs.length)
					&& (cp[pi] == cs[si] || (cp[pi] == '.' && si < cs.length))) {
				if (doMatch(cs, cp, si, pi + 2)) {
					return true;
				}
				++si;
			}
			return doMatch(cs, cp, si, pi + 2);
		}
	}

}
