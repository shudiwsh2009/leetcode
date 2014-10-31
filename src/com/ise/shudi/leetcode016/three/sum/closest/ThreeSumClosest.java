package com.ise.shudi.leetcode016.three.sum.closest;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-3, -2, -5, 3, -4};
		int target = -1;
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(num, target));
	}

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int closest = Integer.MAX_VALUE / 2;
		for(int i = 0; i < num.length - 2; ++i) {
			if(i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int m = i + 1, n = num.length - 1;
			while(m < n) {
				if(m > i + 1 && num[m] == num[m - 1]) {
					++m;
					continue;
				} else if(n < num.length - 1 && num[n] == num[n + 1]) {
					--n;
					continue;
				}
				int sum = num[i] + num[m] + num[n];
				if(sum == target) {
					return target;
				} else if(sum > target) {
					--n;
				} else {
					++m;
				}
				if(Math.abs(sum - target) < Math.abs(closest - target)) {
					closest = sum;
				}
			}
		}
		return closest;
	}
}
