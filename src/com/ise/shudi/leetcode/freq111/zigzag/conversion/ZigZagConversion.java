package com.ise.shudi.leetcode.freq111.zigzag.conversion;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		int nRows = 3;
		ZigZagConversion zc = new ZigZagConversion();
		System.out.println(zc.convert(s, nRows));
	}
	
	public String convert(String s, int nRows) {
		if(nRows == 1 || s.isEmpty()) {
			return s;
		}
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cycle = 2 * nRows - 2;
        for(int r = 1; r <= nRows; ++r) {
        	if(r == 1) {
        		for(int d = 1;; ++d) {
        			if((d - 1) * cycle + 1 - 1 < cs.length) {
        				sb.append(cs[(d - 1) * cycle + 1 - 1]);
        			} else {
        				break;
        			}
        		}
        	} else if(r == nRows) {
        		for(int d = 1;; ++d) {
        			if((d - 1) * cycle + nRows - 1 < cs.length) {
        				sb.append(cs[(d - 1) * cycle + nRows - 1]);
        			} else {
        				break;
        			}
        		}
        	} else {
        		for(int d = 1;; ++d) {
        			if((d - 1) * cycle + r - 1 < cs.length) {
        				sb.append(cs[(d - 1) * cycle + r - 1]);
        			} else {
        				break;
        			}
        			if(d * cycle - (r - 2) - 1 < cs.length) {
        				sb.append(cs[d * cycle - (r - 2) - 1]);
        			} else {
        				break;
        			}
        		}
        	}
        }
        return sb.toString();
    }

}
