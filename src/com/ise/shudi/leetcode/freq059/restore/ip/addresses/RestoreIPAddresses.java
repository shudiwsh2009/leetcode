package com.ise.shudi.leetcode.freq059.restore.ip.addresses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "25525511135";
		RestoreIPAddresses ripa = new RestoreIPAddresses();
		List<String> result = ripa.restoreIpAddresses(s);
		for(String ss : result) {
			System.out.println(ss);
		}
	}
	
	public List<String> restoreIpAddresses(String s) {
		if(s.length() < 4 || s.length() > 12) {
			return new ArrayList<String>();
		}
        List<String> result = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        doRestore(s, 0, stack, result);
        return result;
    }
	
	private void doRestore(String s, int index, Stack<String> stack, List<String> result) {
		if(stack.size() == 4 && index == s.length()) {
			String tmp = "";
			for(String ss : stack) {
				tmp += (ss + ".");
			}
			result.add(tmp.substring(0, tmp.length() - 1));
			return;
		} else if(index >= s.length()) {
			return;
		}
		if(s.charAt(index) == '0') {
			stack.push("0");
			doRestore(s, index + 1, stack, result);
			stack.pop();
		} else {
			for(int i = 1; i <= 3 && index + i <= s.length(); ++i) {
				String cut = s.substring(index, index + i);
				if(Integer.parseInt(cut) <= 255) {
					stack.push(cut);
					doRestore(s, index + i, stack, result);
					stack.pop();
				}
			}
		}
	}

}
