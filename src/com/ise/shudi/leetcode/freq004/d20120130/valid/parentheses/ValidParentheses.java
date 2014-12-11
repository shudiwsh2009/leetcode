package com.ise.shudi.leetcode.freq004.d20120130.valid.parentheses;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{f}a([w]2({}4t))f]a";
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid(s));
	}

	public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : cs) {
        	if(c == '(' || c == '[' || c == '{') {
        		stack.push(c);
        	} else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
        		return false;
        	} else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
        		return false;
        	} else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
        		return false;
        	}
        }
        if(stack.isEmpty()) {
        	return true;
        }
        return false;
    }
}
