package com.ise.shudi.leetcode.freq036.reverse.integer;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int x = 1534236469;
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(x));
	}
	
	// special case: -2147483648, 1534236469
	public int reverse(int x) {
		int flag = 1;
		if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
			return 0;
		} else if(x < 0 && x > Integer.MIN_VALUE) {
        	flag = -1;
        	x = -x;
        }
		int result = 0;
		while(x > 0) {
			int dec = x % 10;
			result = result * 10 + dec;
			x = x / 10;
			if((result > Integer.MAX_VALUE / 10 && x > 0) 
					|| (result == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10)) {
				return 0;
			}
		}
		return result * flag;
    }

}
