package com.ise.shudi.leetcode005.longest.palindromic.substring;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome2(s));
	}

	// DP: O(n2) time and O(1) space
	public String longestPalindrome3(String s) {
		int n = s.length();
		if (n <= 1) {
			return s;
		}
		String longest = s.substring(0, 1);
		for (int i = 0; i < n - 1; ++i) {
			String p1 = expandAroundCenter(s, i, i);
			if (p1.length() > longest.length()) {
				longest = p1;
			}
			String p2 = expandAroundCenter(s, i, i + 1);
			if (p2.length() > longest.length()) {
				longest = p2;
			}
		}
		return longest;
	}

	private String expandAroundCenter(String s, int l, int r) {
		int n = s.length();
		while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
			--l;
			++r;
		}
		return s.substring(l + 1, r);
	}

	// DP: O(n2) time and O(n2) space
	public String longestPalindrome2(String s) {
		int n = s.length();
		char[] cs = s.toCharArray();
		int longestBegin = 0;
		int maxLength = 1;
		boolean p[][] = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			p[i][i] = true;
		}
		for (int i = 0; i < n - 1; ++i) {
			if (cs[i] == cs[i + 1]) {
				p[i][i + 1] = true;
				longestBegin = i;
				maxLength = 2;
			} else {
				p[i][i + 1] = false;
			}
		}
		for (int l = 3; l <= n; ++l) {
			for (int i = 0; i < n - l + 1; ++i) {
				int j = i + l - 1;
				if (cs[i] == cs[j] && p[i + 1][j - 1] == true) {
					p[i][j] = true;
					longestBegin = i;
					maxLength = l;
				}
			}
		}
		return s.substring(longestBegin, longestBegin + maxLength);
	}

	// DP: not continuous substring
	public String longestPalindrome1(String s) {
		int n = s.length();
		if (n <= 1) {
			return s;
		}
		int[][] c = new int[n + 1][n + 1];
		int[][] b = new int[n + 1][n + 1];
		char[] cs = s.toCharArray();
		for (int i = 1; i <= n; ++i) {
			c[i][i] = 1;
		}
		for (int i = 1; i < n; ++i) {
			if (cs[i - 1] == cs[i]) {
				c[i][i + 1] = 2;
				b[i][i + 1] = 2;
			} else {
				c[i][i + 1] = 1;
				b[i][i + 1] = 3;
			}
		}
		for (int l = 3; l <= n; ++l) {
			for (int i = 1; i <= n - l + 1; ++i) {
				int j = i + l - 1;
				if (cs[i - 1] == cs[j - 1]) {
					c[i][j] = c[i + 1][j - 1] + 2;
					b[i][j] = 2;
				} else if (c[i + 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i + 1][j];
					b[i][j] = 3;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		printLPS(cs, b, 1, n, sb);
		return sb.toString();
	}

	private void printLPS(char[] cs, int[][] b, int i, int j, StringBuilder sb) {
		if (i == j) {
			sb.append(cs[i - 1]);
		} else if (b[i][j] == 2) {
			sb.append(cs[i - 1]);
			printLPS(cs, b, i + 1, j - 1, sb);
			sb.append(cs[j - 1]);
		} else if (b[i][j] == 1) {
			printLPS(cs, b, i + 1, j, sb);
		} else if (b[i][j] == 3) {
			printLPS(cs, b, i, j - 1, sb);
		}
	}

}
