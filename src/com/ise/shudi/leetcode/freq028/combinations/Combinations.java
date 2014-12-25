package com.ise.shudi.leetcode.freq028.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations com = new Combinations();
		int n = 4, k = 2;
		List<List<Integer>> result = com.combine(n, k);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k > n || k == 0) {
        	return result;
        }
        List<Integer> per = new ArrayList<Integer>();
        doCombine(result, per, n, k);
        return result;
    }
	
	private void doCombine(List<List<Integer>> result, List<Integer> per, int n, int k) {
		if(per.size() == k) {
			List<Integer> tmp = new ArrayList<Integer>();
			for(int i : per) {
				tmp.add(i);
			}
			result.add(tmp);
		}
		if(per.size() == 0) {
			for(int i = 1; i <= n; ++i) {
				per.add(i);
				doCombine(result, per, n, k);
				per.remove(0);
			}
		} else {
			if(n - per.get(per.size() - 1) + per.size() < k) {
				return;
			}
			for(int i = per.get(per.size() - 1) + 1; i <= n; ++i) {
				per.add(i);
				doCombine(result, per, n, k);
				per.remove(per.size() - 1);
			}
		}
	}

}
