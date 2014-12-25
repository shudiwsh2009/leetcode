package com.ise.shudi.leetcode.freq073.longest.palindromic.substring;

/**
 * @author Shudi
 * 记忆�?长回文的�?右边界位置和中心位置
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome(s));
	}

	// O(n) Manacher's Algorithm
	public String longestPalindrome(String s) {
		if(s.length() < 2) {
			return s;
		}
		char[] cs = insertSharp(s).toCharArray();
		int rightEnd = 0, midPos = 0;
		int[] pRad = new int[cs.length];
		for(int i = 1; i < cs.length - 1; ++i) {
			if(rightEnd > i) {
				pRad[i] = Math.min(rightEnd - i, pRad[2 * midPos - i]);
			} else {
				pRad[i] = 0; 
			}
			while(cs[i + pRad[i] + 1] == cs[i - pRad[i] - 1]) {
				++pRad[i];
			}
			if(i + pRad[i] > rightEnd) {
				rightEnd = i + pRad[i];
				midPos = i;
			}
		}
		int maxLen = 0, startPos = 0;
		for(int i = 1; i < pRad.length - 1; ++i) {
			if(pRad[i] > maxLen) {
				maxLen = pRad[i];
				startPos = (i - maxLen - 1) / 2;
			}
		}
		return s.substring(startPos, startPos + maxLen);		
	}
	
	// O(n^2)
	public String longestPalindrome1(String s) {
		if(s.length() < 2) {
			return s;
		}
        char[] cs = s.toCharArray();
        int left = 0, right = 0;
        int max = 0;
        String lp = "";
        for(int mid = 0; mid < cs.length; ++mid) {
        	left = mid;
        	right = mid;
        	while(left >= 0 && right <= cs.length - 1) {
        		if(cs[left] == cs[right]) {
        			if(right - left + 1 > max) {
        				max = right - left + 1;
        				lp = s.substring(left, right + 1);
        			}
        			--left;
        			++right;
        		} else {
        			break;
        		}
        	}
        	if(mid != cs.length - 1) {
        		left = mid;
        		right = mid + 1;
        		while(left >= 0 && right <= cs.length - 1) {
        			if(cs[left] == cs[right]) {
            			if(right - left + 1 > max) {
            				max = right - left + 1;
            				lp = s.substring(left, right + 1);
            			}
            			--left;
            			++right;
        			} else {
        				break;
        			}
        		}
        	}
        }
        return lp;
    }
	
	private String insertSharp(String s) {
		String result = "!";
		for(char c : s.toCharArray()) {
			result += ("#" + c);
		}
		result += "#?";
		return result;
	}
}
