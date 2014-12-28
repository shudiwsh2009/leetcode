package com.ise.shudi.leetcode.freq082.count.and.say;

public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		CountandSay cs = new CountandSay();
		System.out.println(cs.countAndSay(n));
	}
	
	public String countAndSay(int n) {
		String s = "1";
        while(--n > 0) {
        	StringBuilder sb = new StringBuilder();
        	char[] cs = s.toCharArray();
        	for(int i = 0; i < cs.length; ++i) {
        		int count = 1;
        		while((i + 1) < cs.length && cs[i + 1] == cs[i]) {
        			++count;
        			++i;
        		}
        		sb.append(String.valueOf(count) + String.valueOf(cs[i]));
        	}
        	s = sb.toString();
        }
        return s;
    }

}
