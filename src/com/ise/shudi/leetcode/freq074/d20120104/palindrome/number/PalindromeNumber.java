package com.ise.shudi.leetcode.freq074.d20120104.palindrome.number;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1000000001;
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(x));
	}
	
	public boolean isPalindrome(int x) {
        if(x < 0) {
        	return false;
        }
        long large = 10, small = 10;
        while(x / large > 0) {
        	large *= 10;
        }
        large /= 10;
        while(large >= small && (x / large) % 10 == (x % small) / (small / 10)) {
        	large /= 10;
        	small *= 10;
        }
        if(large >= small) {
        	return false;
        }
        return true;
    }

}
