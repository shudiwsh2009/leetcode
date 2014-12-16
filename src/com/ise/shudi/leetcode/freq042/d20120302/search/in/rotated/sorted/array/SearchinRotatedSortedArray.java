package com.ise.shudi.leetcode.freq042.d20120302.search.in.rotated.sorted.array;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while(low < high) {
        	int mid = (low + high) / 2;
        	if(A[mid] > A[high]) {
        		low = mid + 1;
        	} else {
        		high = mid;
        	}
        }
        int rotated = low;
        low = 0;
        high = A.length - 1;
        // The usual binary search and accounting for rotation.
        while(low <= high){
            int mid = (low + high) / 2;
            int realmid = (mid + rotated) % A.length;
            if(A[realmid] == target) {
            	return realmid;
            }
            if(A[realmid]<target) {
            	low = mid + 1;
            } else {
            	high = mid - 1;
            }
        }
        return -1;
    }

}
