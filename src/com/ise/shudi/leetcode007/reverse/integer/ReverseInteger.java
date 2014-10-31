package com.ise.shudi.leetcode007.reverse.integer;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = -200;
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(i));
	}

	public int reverse(int x) {
		int neg = x >= 0 ? 1 : -1;
		if (neg == -1) {
			x = -x;
		}
		long ret = 0;
		while (x > 0) {
			ret = ret * 10 + x % 10;
			x = x / 10;
		}
		ret *= neg;
		if (ret > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (ret < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return (int) ret;
		}
	}

}
