package com.ise.shudi.leetcode006.zigzag.conversion;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABACAD";
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert(s, 2));
	}

	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		char[] cs = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= nRows; ++i) {
			if (i == 1) {
				int m = 1;
				while (m <= cs.length) {
					sb.append(cs[m - 1]);
					m += (2 * (nRows - 1));
				}
			} else if (i == nRows) {
				int m = nRows;
				while (m <= cs.length) {
					sb.append(cs[m - 1]);
					m += (2 * (nRows - 1));
				}
			} else {
				int m = i;
				int n = 2 * (nRows - 1) - (i - 2);
				while (m <= cs.length) {
					sb.append(cs[m - 1]);
					m += (2 * (nRows - 1));
					if (n > cs.length) {
						break;
					}
					sb.append(cs[n - 1]);
					n += (2 * (nRows - 1));
				}
			}
		}
		return sb.toString();
	}
}
