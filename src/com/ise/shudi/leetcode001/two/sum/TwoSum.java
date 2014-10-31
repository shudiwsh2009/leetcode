package com.ise.shudi.leetcode001.two.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> hmNumbers = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; ++i) {
			if (hmNumbers.containsKey(target - numbers[i])) {
				result[0] = hmNumbers.get(target - numbers[i]);
				result[1] = i + 1;
				return result;
			}
			hmNumbers.put(numbers[i], i + 1);
		}
		return result;
	}
}
