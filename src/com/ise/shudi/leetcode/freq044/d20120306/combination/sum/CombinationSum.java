package com.ise.shudi.leetcode.freq044.d20120306.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,2, 3, 6, 7};
		int target = 7;
		CombinationSum cs = new CombinationSum();
		List<List<Integer>> result = cs.combinationSum(candidates, target);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		doCombination(candidates, 0, target, result, stack);
		return result;
	}

	private void doCombination(int[] candidates, int start, int target,
			List<List<Integer>> result, Stack<Integer> stack) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(stack));
			return;
		}
		for(int i = start; i < candidates.length; ++i) {
			if(candidates[i] > target) {
				return;
			}
			if(i > 0 && candidates[i] == candidates[i - 1]) {
				continue;
			}
			stack.push(candidates[i]);
			doCombination(candidates, i, target - candidates[i], result, stack);
			stack.pop();
		}
	}

}
