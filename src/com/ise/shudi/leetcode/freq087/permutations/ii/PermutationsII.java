package com.ise.shudi.leetcode.freq087.permutations.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 1};
		PermutationsII per = new PermutationsII();
		List<List<Integer>> result = per.permuteUnique(num);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] used = new boolean[num.length];
		doPermutation(result, stack, num, used);
		return result;
    }
	
	private void doPermutation(List<List<Integer>> result, Stack<Integer> stack, int[] num,
			boolean[] used) {
		if(stack.size() == num.length) {
			result.add(new ArrayList<Integer>(stack));
			return;
		}
		int last = Integer.MAX_VALUE;
		for(int i = 0; i < num.length; ++i) {
			if(!used[i] && num[i] != last) {
				stack.push(num[i]);
				last = num[i];
				used[i] = true;
				doPermutation(result, stack, num, used);
				used[i] = false;
				stack.pop();
			}
		}
	}

}
