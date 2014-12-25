package com.ise.shudi.leetcode.freq034.palindrome.partitioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shudi
 * @TODO https://oj.leetcode.com/discuss/9623/my-java-dp-only-solution-without-recursion-o-n-2
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> result = pp.partition(s);
		for(List<String> l : result) {
			for(String ss : l) {
				System.out.print(ss + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        Stack<String> stack = new Stack<String>();
        doPartition(s, 0, result, stack);
        return result;
    }
	
	private void doPartition(String s, int index, List<List<String>> result, Stack<String> stack) {
		if(index == s.length()) {
			List<String> tmp = new ArrayList<String>();
			for(String ss : stack) {
				tmp.add(ss);
			}
			result.add(tmp);
		}
		for(int i = 1; i <= s.length() - index; ++i) {
			if(isPalindrome(s.substring(index, index + i))) {
				stack.push(s.substring(index, index + i));
				doPartition(s, index + i, result, stack);
				stack.pop();
			}
		}
	}
	
	private boolean isPalindrome(String s) {
		if(s.length() <= 1) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while(i <= j) {
			if(s.charAt(i) == s.charAt(j)) {
				++i;
				--j;
			} else {
				return false;
			}
		}
		return true;
	}

}
