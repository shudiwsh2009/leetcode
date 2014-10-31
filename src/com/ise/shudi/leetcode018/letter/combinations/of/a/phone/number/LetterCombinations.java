package com.ise.shudi.leetcode018.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "23";
		LetterCombinations lc = new LetterCombinations();
		System.out.println(lc.letterCombinations(digits));
	}

	public List<String> letterCombinations(String digits) {
		Map<Character, char[]> letterMap = new HashMap<Character, char[]>();
		letterMap.put('0', new char[] {});
		letterMap.put('1', new char[] {});
		letterMap.put('2', new char[] {'a', 'b', 'c'});
		letterMap.put('3', new char[] {'d', 'e', 'f'});
		letterMap.put('4', new char[] {'g', 'h', 'i'});
		letterMap.put('5', new char[] {'j', 'k', 'l'});
		letterMap.put('6', new char[] {'m', 'n', 'o'});
		letterMap.put('7', new char[] {'p', 'q', 'r', 's'});
		letterMap.put('8', new char[] {'t', 'u', 'v'});
		letterMap.put('9', new char[] {'w', 'x', 'y', 'z'});
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		combineRecursively(letterMap, digits, sb, result, 0);
		return result;
	}
	
	private void combineRecursively(Map<Character, char[]> letterMap, String digits,
			StringBuilder sb, List<String> result, int i) {
		if(i == digits.length()) {
			result.add(sb.toString());
			return;
		}
		for(char c : letterMap.get(digits.charAt(i))) {
			sb.append(c);
			combineRecursively(letterMap, digits, sb, result, i + 1);
			sb.deleteCharAt(i);
		}
	}
}
