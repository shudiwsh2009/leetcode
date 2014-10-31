package com.ise.shudi.leetcode012.integer.to.roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(3999));
	}

	private static Map<Integer, String> hmNumToRoman = new LinkedHashMap<Integer, String>();
	static {
		hmNumToRoman.put(1000, "M");
		hmNumToRoman.put(900, "CM");
		hmNumToRoman.put(500, "D");
		hmNumToRoman.put(400, "CD");
		hmNumToRoman.put(100, "C");
		hmNumToRoman.put(90, "XC");
		hmNumToRoman.put(50, "L");
		hmNumToRoman.put(40, "XL");
		hmNumToRoman.put(10, "X");
		hmNumToRoman.put(9, "IX");
		hmNumToRoman.put(5, "V");
		hmNumToRoman.put(4, "IV");
		hmNumToRoman.put(1, "I");
	}

	public String intToRoman(int num) {
		for (int i : hmNumToRoman.keySet()) {
			if (num >= i) {
				return hmNumToRoman.get(i) + intToRoman(num - i);
			}
		}
		return "";
	}

}
