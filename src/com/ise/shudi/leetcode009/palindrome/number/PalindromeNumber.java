package com.ise.shudi.leetcode009.palindrome.number;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1000000001;
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(x));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		long d = 10;
		long e = 10;
		while (x / d != 0) {
			d *= 10;
		}
		while (d > e) {
			if ((x % d) / (d / 10) != (x % e) / (e / 10)) {
				return false;
			}
			d /= 10;
			e *= 10;
		}
		return true;
	}
}
