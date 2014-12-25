package com.ise.shudi.leetcode.freq002.string.to.integer;

public class StringtoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		String str = "  -0012a42";
		StringtoInteger si = new StringtoInteger();
		System.out.println(si.atoi(str));
	}
	
	public int atoi(String str) {
        str = str.trim();
        if(str.isEmpty()) {
        	return 0;
        }
        int flag = 1;
        if(str.startsWith("-")) {
        	flag = -1;
        	str = str.substring(1);
        } else if(str.startsWith("+")) {
        	flag = 1;
        	str = str.substring(1);
        }
        char[] cs = str.toCharArray();
        if(cs[0] > '9' || cs[0] < '0') {
        	return 0;
        }
        int result = 0;
        for(char c : cs) {
        	if(c >= '0' && c <= '9') {
        		if(result > Integer.MAX_VALUE / 10
        				|| (result == Integer.MAX_VALUE / 10 && c - '0' > 7)) {
        			return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        		}
        		result = result * 10 + (c - '0');
        	} else {
        		break;
        	}
        }
        return result * flag;
    }

}
