package com.ise.shudi.leetcode.freq020.generate.parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		generateRecursively(n, result, sb, 0, 0);
		return result;
	}
	
	private void generateRecursively(int n, List<String> result, StringBuilder sb,
			int used, int left) {
		if(used == n && left == 0) {
			result.add(sb.toString());
			return;
		}
		if(used < n) {
			sb.append("(");
			generateRecursively(n, result, sb, used + 1, left + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(left > 0) {
			sb.append(")");
			generateRecursively(n, result, sb, used, left - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
