package com.ise.shudi.leetcode.freq069.longest.consecutive.sequence;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7};
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(num));
	}
	
	public int longestConsecutive(int[] num) {
        int max = 0;
        Map<Integer, Integer> hmInterval = new HashMap<Integer, Integer>();
        for(int i : num) {
        	if(hmInterval.containsKey(i)) {
        		continue;
        	} else {
        		int left = hmInterval.containsKey(i - 1) ? hmInterval.get(i - 1) : 0;
        		int right = hmInterval.containsKey(i + 1) ? hmInterval.get(i + 1) : 0;
        		int interval = left + right + 1;
        		hmInterval.put(i, interval);
        		max = Math.max(max, interval);
        		hmInterval.put(i - left, interval);
        		hmInterval.put(i + right, interval);
        	}
        }
        return max;
    }

}
