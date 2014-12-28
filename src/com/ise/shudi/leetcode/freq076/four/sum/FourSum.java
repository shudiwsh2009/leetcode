package com.ise.shudi.leetcode.freq076.four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i <= num.length - 4; ++i) {
        	if(i > 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	for(int j = i + 1; j <= num.length - 3; ++j) {
        		if(j > i + 1 && num[j] == num[j - 1]) {
        			continue;
        		}
        		int l = j + 1, r = num.length - 1;
        		while(l < r) {
        			if(l > j + 1 && num[l] == num[l - 1]) {
        				++l;
        			} else if(r < num.length - 1 && num[r] == num[r + 1]) {
        				--r;
        			} else {
        				int sum = num[i] + num[j] + num[l] + num[r];
        				if(sum == target) {
        					List<Integer> tmp = new ArrayList<Integer>();
        					tmp.add(num[i]);
        					tmp.add(num[j]);
        					tmp.add(num[l]);
        					tmp.add(num[r]);
        					result.add(tmp);
        					++l;
        					--r;
        				} else if(sum < target) {
        					++l;
        				} else {
        					--r;
        				}
        			}
        		}
        	}
        }
        return result;
    }

}
