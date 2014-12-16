package com.ise.shudi.leetcode.freq041.d20120218.divide.two.integers;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int divide(int dividend, int divisor) {
		if(dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
        if (dividend == 0 || divisor == 1)
            return dividend;
        long divid = dividend;
        long divis = divisor;
 
        boolean neg = false;
        int result = 0;
 
        if (dividend < 0) {
            neg = !neg;
            divid = -divid;
        }
        if (divisor < 0) {
            neg = !neg;
            divis = -divis;
        }
 
        long[] multi = new long[32];
 
        for (int i = 0; i < 32; i++)
            multi[i] = divis << i;
 
        for (int i = 31; i >= 0; i--) {
            if (divid >= multi[i]) {
                result += 1 << i;
                divid -= multi[i];
            }
        }
 
        return (neg ? -1 : 1) * result;
    }

}
