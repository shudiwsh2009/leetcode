package com.ise.shudi.leetcode.freq079.search.insert.position;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 3, 5, 6};
		int target = 0;
		SearchInsertPosition sip = new SearchInsertPosition();
		System.out.println(sip.searchInsert(A, target));
	}
	
	public int searchInsert(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while(l <= r) {
        	int mid = l + ((r - l) >> 1);
        	if(A[mid] == target) {
        		return mid;
        	} else if(A[mid] < target) {
        		if(mid == A.length - 1) {
        			return A.length;
        		} else if(A[mid + 1] > target) {
        			return mid + 1;
        		} else {
        			l = mid + 1;
        		}
        	} else {
        		if(mid == 0) {
        			return 0;
        		} else if(A[mid - 1] < target) {
        			return mid;
        		} else {
        			r = mid - 1;
        		}
        	}
        }
        return 0;
    }

}
