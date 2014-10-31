package com.ise.shudi.leetcode015.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1,0,1,2,-1,4};
		ThreeSum ts = new ThreeSum();
		System.out.println(ts.threeSum(num));
	}

	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i < num.length - 2; ++i) {
			if(i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int m = i + 1, n = num.length - 1;
			while(m < n) {
				if(m > i + 1 && num[m] == num[m - 1]) {
					++m;
					continue;
				} else if(n < num.length - 1 && num[n] == num[n + 1]) {
					--n;
					continue;
				}
				if(num[i] + num[m] + num[n] == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[m]);
					list.add(num[n]);
					result.add(list);
					++m;
					--n;
				} else if(num[i] + num[m] + num[n] > 0) {
					--n;
				} else {
					++m;
				}
			}
		}
		return result;
	}

}
