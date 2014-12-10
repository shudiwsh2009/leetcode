package com.ise.shudi.leetcode.freq003.d20120117.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1, 0, 1, 2, -1, 4};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> result = ts.threeSum(num);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> threeSum(int[] num) {
		if(num.length < 3) {
			return new ArrayList<List<Integer>>();
		}
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; ++i) {
        	if(i > 0 && num[i] == num[i - 1]) {
        		continue;
        	}
        	int j = i + 1, k = num.length - 1;
        	while(j < k && j < num.length && k >= 0) {
        		if(j > i + 1 && num[j] == num[j - 1]) {
        			++j;        			
        		} else if(k < num.length - 1 && num[k] == num[k + 1]) {
        			--k;
        		} else {
        			if(num[i] + num[j] + num[k] == 0) {
        				List<Integer> sub = new ArrayList<Integer>();
        				sub.add(num[i]);
        				sub.add(num[j]);
        				sub.add(num[k]);
        				result.add(sub);
        				++j;
        				--k;
        			} else if(num[i] + num[j] + num[k] > 0) {
        				--k;
        			} else {
        				++j;
        			}
        		}
        	}
        }
        return result;
    }
}
