package com.ise.shudi.leetcode.freq001.d20110313.two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2, 7, 11, 15};
		int target = 17;
		TwoSum ts = new TwoSum();
		int[] result = ts.twoSum(numbers, target);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}

	public int[] twoSum(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		Arrays.sort(numbers);
		int[] result = new int[2];
		while(i < j) {
			if(numbers[i] + numbers[j] == target) {
				result[0] = i;
				result[1] = j;
				return result;
			} else if(numbers[i] + numbers[j] < target) {
				++i;
			} else {
				--j;
			}
		}
		return result;
	}
	
	public int[] twoSum1(int[] numbers, int target) {
		Map<Integer, Integer> hmNum = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for(int i = 0; i < numbers.length; ++i) {
			if(hmNum.containsKey(target - numbers[i])) {
				result[0] = hmNum.get(target - numbers[i]);
				result[1] = i + 1;
				return result;
			} else {
				if(!hmNum.containsKey(numbers[i])) {
					hmNum.put(numbers[i], i + 1);
				}
			}
		}
		return result;
	}
}
