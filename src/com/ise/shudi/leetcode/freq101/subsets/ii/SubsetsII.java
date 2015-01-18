package com.ise.shudi.leetcode.freq101.subsets.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1, 2, 2};
		SubsetsII ss = new SubsetsII();
		List<List<Integer>> result = ss.subsetsWithDup(S);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		List<Integer> per = new ArrayList<Integer>();
		computeSubsets(result, per, num, 0);
		return result;
    }
	
	private void computeSubsets(List<List<Integer>> result, List<Integer> per,
			int[] num, int index) {
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.addAll(per);
		result.add(tmp);
		
		int last = Integer.MIN_VALUE;
		for(int i = index; i < num.length; ++i) {
			if(num[i] == last) {
				continue;
			}
			last = num[i];
			per.add(num[i]);
			computeSubsets(result, per, num, i + 1);
			per.remove(per.size() - 1);
		}
	}

}
