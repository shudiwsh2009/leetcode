package com.ise.shudi.leetcode.freq100.gray.code;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
        if(n <= 1) {
        	for(int i = 0; i <= n; ++i) {
        		result.add(i);
        	}
        	return result;
        }
        result = grayCode(n - 1);
        List<Integer> r = reverseList(result);
        int x = 1 << (n - 1);
        for(int i = 0; i < r.size(); ++i) {
        	result.add(r.get(i) + x);
        }
        return result;
    }
	
	private List<Integer> reverseList(List<Integer> list) {
		List<Integer> r = new ArrayList<Integer>();
		for(int i = list.size() - 1; i >= 0; --i) {
			r.add(list.get(i));
		}
		return r;
	}

}
