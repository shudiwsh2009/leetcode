package com.ise.shudi.leetcode017.four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 0, -1, 0, -2, 2};
		int target = 0;
		FourSum fs = new FourSum();
		System.out.println(fs.fourSum(num, target));
	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length - 3; ++i) {
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < num.length - 2; ++j) {
				if (j > i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				int m = j + 1, n = num.length - 1;
				while (m < n) {
					if (m > j + 1 && num[m] == num[m - 1]) {
						++m;
						continue;
					} else if (n < num.length - 1 && num[n] == num[n + 1]) {
						--n;
						continue;
					}
					int sum = num[i] + num[j] + num[m] + num[n];
					if (sum == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[m]);
						list.add(num[n]);
						result.add(list);
						++m;
						--n;
					} else if (sum > target) {
						--n;
					} else {
						++m;
					}
				}
			}
		}
		return result;
	}
}
