package com.ise.shudi.leetcode.freq015.d20130112.valid.palindrome;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome(s));
	}
	
	public boolean isPalindrome(String s) {
        char[] cs = new char[s.length()];
        int length = 0;
        for(char c : s.toLowerCase().toCharArray()) {
        	if(Character.isLetterOrDigit(c)) {
        		cs[length++] = c;
        	}
        }
        if(length == 0) {
        	return true;
        }
        int i = 0, j = length - 1;
        while(i < j) {
        	if(cs[i] != cs[j]) {
        		return false;
        	}
        	++i;
        	--j;
        }
        return true;
    }

}
