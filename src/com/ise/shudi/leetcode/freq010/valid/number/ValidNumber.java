package com.ise.shudi.leetcode.freq010.valid.number;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isNumber(String s) {
        char[] cs = s.trim().toCharArray();
        int state = 0, flag = 0;
        for(int i = 0; i < cs.length; ++i) {
        	if(cs[i] >= '0' && cs[i] <= '9') {
        		flag=1;
        		if(state <= 2) {
        			state = 2;
        		} else {
        			state = (state <= 5) ? 5 : 7;
        		}
        	} else if(cs[i] == '+' || cs[i] == '-') {
        		if(state == 0 || state == 3) {
        			++state;
        		} else {
					return false;
				}
        	} else if(cs[i] == '.') {
        		if(state <= 2) {
        			state = 6;
        		} else {
        			return false;
        		}
        	} else if(cs[i] == 'e') {
        		if(flag == 1 && (state == 2 || state == 6 || state == 7)) {
        			state = 3;
        		} else {
        			return false;
        		}
        	} else {
        		return false;
        	}
        }
        return (state == 2 || state == 5 || (flag == 1 && state == 6) || state == 7);
    }

}
