package com.ise.shudi.leetcode.freq055.search.in.rotated.sorted.array.ii;

public class SearchinRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 1};
		int target = 0;
		SearchinRotatedSortedArrayII srsa = new SearchinRotatedSortedArrayII();
		System.out.println(srsa.search(A, target));
	}
	
	public boolean search(int[] A, int target) {
        int low = 0, high = A.length - 1;
        if(A == null || A.length == 0) {
        	return false;
        }
        while(low <= high) {
        	int mid = low + ((high - low) >> 1);
        	if(A[mid] == target) {
        		return true;
        	} else if(A[low] < A[mid]) {
        		if(A[low] <= target && target < A[mid]) {
        			high = mid - 1;
        		} else {
        			low = mid + 1;
        		}
        	} else if(A[low] > A[mid]) {
        		if(A[mid] < target && target <= A[high]) {
        			low = mid + 1;
        		} else {
        			high = mid - 1;
        		}
        	} else {
        		++low;
        	}
        }
        return false;
    }
	
}
