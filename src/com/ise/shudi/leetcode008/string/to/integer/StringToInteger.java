package com.ise.shudi.leetcode008.string.to.integer;

public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.atoi("1"));
	}

	public int atoi(String str) {
		str = str.trim();
		if (str.isEmpty()) {
			return 0;
		}
		String tmp = "";
		boolean positive = true;
		if (str.startsWith("+")) {
			positive = true;
			str = str.substring(1, str.length());
		} else if (str.startsWith("-")) {
			positive = false;
			str = str.substring(1, str.length());
		}
		if (str.isEmpty()) {
			return 0;
		}
		for (char c : str.toCharArray()) {
			if (c >= '0' && c <= '9') {
				tmp += c;
			} else {
				break;
			}
		}
		if (tmp.isEmpty()) {
			return 0;
		}
		double d = Double.parseDouble(tmp);
		if (positive && d > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (!positive && (-d) < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (!positive) {
			d = -d;
		}
		return (int) d;
	}

	public int atoi2(String str) {
		int sign = 1, base = 0, i = 0;
		str = str.trim();
		if (str.isEmpty()) {
			return 0;
		}
		char[] cArray = str.toCharArray();
		if (cArray[i] == '+' || cArray[i] == '-') {
			sign = (cArray[i++] == '+') ? 1 : -1;
		}
		while (i < cArray.length && cArray[i] >= '0' && cArray[i] <= '9') {
			if (base > Integer.MAX_VALUE / 10
					|| (base == Integer.MAX_VALUE / 10 && cArray[i] > '7')) {
				if (sign == 1) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
			base = base * 10 + cArray[i++] - '0';
		}
		return sign * base;
	}

}
