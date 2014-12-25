package com.ise.shudi.leetcode.freq027.sqrt;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sqrt(int x) {
		if (0 == x) return 0;
        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
