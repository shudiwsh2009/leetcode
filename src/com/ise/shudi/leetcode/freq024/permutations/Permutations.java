package com.ise.shudi.leetcode.freq024.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 2, 3};
		Permutations per = new Permutations();
		List<List<Integer>> result = per.permute(num);
		for(List<Integer> l : result) {
			for(int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] used = new boolean[num.length];
		doPermutation(result, stack, num, used);
		return result;
    }
	
	private void doPermutation(List<List<Integer>> result, Stack<Integer> stack, int[] num,
			boolean[] used) {
		if(stack.size() == num.length) {
			List<Integer> tmp = new ArrayList<Integer>();
			for(int i : stack) {
				tmp.add(i);
			}
			result.add(tmp);
		}
		for(int i = 0; i < num.length; ++i) {
			if(!used[i]) {
				stack.push(num[i]);
				used[i] = true;
				doPermutation(result, stack, num, used);
				used[i] = false;
				stack.pop();
			}
		}
	}

}
