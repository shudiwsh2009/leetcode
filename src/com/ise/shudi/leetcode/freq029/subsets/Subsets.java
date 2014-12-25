package com.ise.shudi.leetcode.freq029.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1, 2, 3};
		Subsets ss = new Subsets();
		List<List<Integer>> result = ss.subsets(S);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(S);
        List<Integer> per = new ArrayList<Integer>();
        computeSubsets(result, per, S, 0);
        return result;
    }

	private void computeSubsets(List<List<Integer>> result, List<Integer> per, int[] S, int index) {
		List<Integer> tmp = new ArrayList<Integer>();
		for(int i : per) {
			tmp.add(i);
		}
		result.add(tmp);
		
		for(int i = index; i < S.length; ++i) {
			per.add(S[i]);
			computeSubsets(result, per, S, i + 1);
			per.remove(per.size() - 1);
		}
	}
}
