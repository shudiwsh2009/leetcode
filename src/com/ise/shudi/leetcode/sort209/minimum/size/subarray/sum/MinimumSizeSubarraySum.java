package com.ise.shudi.leetcode.sort209.minimum.size.subarray.sum;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 4, 4};
		int s = 4;
		MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
		System.out.println(msss.minSubArrayLen(s, nums));
	}
	
	public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, min = Integer.MAX_VALUE, sum = 0;
        while(i < nums.length && sum < s) {
            sum += nums[i++];
            while(j < i && sum >= s) {
                min = Math.min(min, i - j);
                sum -= nums[j++];
            }
        }
        return min;
    }

}
