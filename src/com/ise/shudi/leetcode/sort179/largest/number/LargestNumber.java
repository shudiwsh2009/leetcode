package com.ise.shudi.leetcode.sort179.largest.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> num = new ArrayList<Integer>();
		num.add(3);
		num.add(30);
		num.add(34);
		num.add(5);
		num.add(9);
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(num));
	}
	
	public String largestNumber(List<Integer> num) {
        Collections.sort(num, new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) {
            	if(v1 == 30 && v2 == 3) {
            		int a = 1;
            	}
                String s1 = String.valueOf(v1);
                String s2 = String.valueOf(v2);
                int i = 0;
                for(i = 0; i < s1.length() && i < s2.length(); ++i) {
                    int n1 = s1.charAt(i) - '0';
                    int n2 = s2.charAt(i) - '0';
                    if(n1 > n2) {
                        return -1;
                    } else if(n1 < n2) {
                        return 1;
                    }
                }
                String s = (s1.length() > s2.length()) ? s1 : s2;
                for(i = i - 1; i < s.length() - 1; ++i) {
                    if(s.charAt(i) < s.charAt(i + 1)) {
                        return (s1.length() > s2.length()) ? -1 : 1;
                    } else if(s.charAt(i) > s.charAt(i + 1)) {
                        return (s1.length() > s2.length()) ? 1 : -1;
                    }
                } 
                return 0;
            }
        });
        StringBuilder builder = new StringBuilder();
        for(int i : num) {
            builder.append(i);
        }
        return builder.toString();
    }


}
