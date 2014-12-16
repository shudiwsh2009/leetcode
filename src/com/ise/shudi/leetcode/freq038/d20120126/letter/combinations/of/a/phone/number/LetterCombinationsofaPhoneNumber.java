package com.ise.shudi.leetcode.freq038.d20120126.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Map<Character, char[]> hmPhone = new HashMap<Character, char[]>();
	static {
		hmPhone.put('2', new char[]{'a', 'b', 'c'});
		hmPhone.put('3', new char[]{'d', 'e', 'f'});
		hmPhone.put('4', new char[]{'g', 'h', 'i'});
		hmPhone.put('5', new char[]{'j', 'k', 'l'});
		hmPhone.put('6', new char[]{'m', 'n', 'o'});
		hmPhone.put('7', new char[]{'p', 'q', 'r', 's'});
		hmPhone.put('8', new char[]{'t', 'u', 'v'});
		hmPhone.put('9', new char[]{'w', 'x', 'y', 'z'});
		hmPhone.put('0', new char[]{' '});
	}
	
	public List<String> letterCombinations(String digits) {
        char[] cd = digits.toCharArray();
        List<String> result = new ArrayList<String>();
        Stack<Character> stack = new Stack<Character>();
        doCombinations(result, stack, cd, 0);
        return result;
    }
	
	private void doCombinations(List<String> result, Stack<Character> stack, char[] cd, int index) {
		if(index == cd.length) {
			String tmp = "";
			for(char c : stack) {
				tmp += c;
			}
			result.add(tmp);
			return;
		}
		if(hmPhone.containsKey(cd[index])) {
			for(char c : hmPhone.get(cd[index])) {
				stack.push(c);
				doCombinations(result, stack, cd, index + 1);
				stack.pop();
			}
		}
	}

}
