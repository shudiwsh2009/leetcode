package com.ise.shudi.leetcode013.roman.to.integer;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("MMMCMXCIX"));
	}

	private static Map<Character, Integer> hmRomanToNum = new HashMap<Character, Integer>();
	static {
		hmRomanToNum.put('I', 1);
		hmRomanToNum.put('V', 5);
		hmRomanToNum.put('X', 10);
		hmRomanToNum.put('L', 50);
		hmRomanToNum.put('C', 100);
		hmRomanToNum.put('D', 500);
		hmRomanToNum.put('M', 1000);
	}

	public int romanToInt(String s) {
		char[] cs = s.toCharArray();
		int num = 0;
		for (int i = 0; i < cs.length; ++i) {
			if (i < cs.length - 1
					&& hmRomanToNum.get(cs[i]) < hmRomanToNum.get(cs[i + 1])) {
				num += (hmRomanToNum.get(cs[i + 1]) - hmRomanToNum.get(cs[i]));
				++i;
			} else {
				num += hmRomanToNum.get(cs[i]);
			}
		}
		return num;
	}

}
