package com.ise.shudi.leetcode.freq083.combination.sum.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {10, 1, 2, 7, 6, 1, 5, 1};
		int target = 8;
		CombinationSumII csii = new CombinationSumII();
		List<List<Integer>> result = csii.combinationSum2(num, target);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		doCombination(num, 0, target, result, stack);
		return result;
    }
	
	private void doCombination(int[] num, int start, int target,
			List<List<Integer>> result, Stack<Integer> stack) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(stack));
			return;
		}
		for(int i = start; i < num.length; ++i) {
			if(num[i] > target) {
				return;
			}
			if(i > start && num[i] == num[i - 1]) {
				continue;
			}
			stack.push(num[i]);
			doCombination(num, i + 1, target - num[i], result, stack);
			stack.pop();
		}
	}

}
