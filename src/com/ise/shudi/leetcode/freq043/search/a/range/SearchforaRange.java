package com.ise.shudi.leetcode.freq043.search.a.range;

public class SearchforaRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1};
		int target = 0;
		SearchforaRange sr = new SearchforaRange();
		int[] result = sr.searchRange(A, target);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	
	public int[] searchRange(int[] A, int target) {
        int mid = binarySearch(A, 0, A.length - 1, target);
        if(mid == -1) {
        	return new int[]{-1, -1};
        }
        int min = mid, max = mid;
        if(mid != 0 && A[mid - 1] == target) {
        	int left = mid - 1;
        	do {
        		min = Math.min(mid, left);
        		left = binarySearch(A, 0, left - 1, target);
        	} while(left != -1);
        }
        if(mid != A.length - 1 && A[mid + 1] == target) {
        	int right = mid + 1;
        	do {
        		max = Math.max(max, right);
        		right = binarySearch(A, right + 1, A.length - 1, target);
        	} while(right != -1);
        }
        return new int[]{min, max};
    }
	
	private int binarySearch(int[] A, int start, int end, int target) {
		while(start <= end) {
			int mid = start + ((end - start) >> 1);
			if(A[mid] == target) {
				return mid;
			} else if(A[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
