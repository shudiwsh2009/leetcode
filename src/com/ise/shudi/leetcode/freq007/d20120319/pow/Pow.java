package com.ise.shudi.leetcode.freq007.d20120319.pow;

public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 3.0;
		int n = 3;
		Pow p = new Pow();
		System.out.println(p.pow(x, n));
	}
	
	public double pow(double x, int n) {
        if(n == 0) {
        	return 1;
        }
        if(n < 0) {
        	n = -n;
        	x = 1 / x;
        }
        return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x , n / 2);
    }

}
