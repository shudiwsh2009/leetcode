package com.ise.shudi.leetcode152.maximum.product.subarray;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 0, 2 };
		MaximumProductSubarray mps = new MaximumProductSubarray();
		System.out.println(mps.maxProduct1(A));
	}

	public int maxProduct(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int maxherepre = A[0];
		int minherepre = A[0];
		int maxsofar = A[0];
		int maxhere, minhere;
		for (int i = 1; i < A.length; ++i) {
			maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]),
					A[i]);
			minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]),
					A[i]);
			maxsofar = Math.max(maxsofar, maxhere);
			maxherepre = maxhere;
			minherepre = minhere;
		}
		return maxsofar;
	}

	public int maxProduct1(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		int max = 0;
		int begin = 0;
		boolean hasZero = false;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] == 0) {
				int subProduct = subMaxProduct(A, begin, i);
				max = max > subProduct ? max : subProduct;
				begin = i + 1;
				hasZero = true;
			}
		}
		if (!hasZero) {
			return subMaxProduct(A, 0, A.length);
		}
		if (begin < A.length) {
			int subProduct = subMaxProduct(A, begin, A.length);
			max = max > subProduct ? max : subProduct;
		}
		return max;
	}

	private int subMaxProduct(int[] A, int begin, int end) {
		if (begin >= end - 1) {
			return A[begin];
		}
		int firstNegPos = Integer.MAX_VALUE;
		int lastNegPos = Integer.MIN_VALUE;
		int numOfNeg = 0;
		for (int i = begin; i < end; ++i) {
			if (A[i] < 0) {
				firstNegPos = firstNegPos > i ? i : firstNegPos;
				lastNegPos = lastNegPos < i ? i : lastNegPos;
				++numOfNeg;
			}
		}
		if (numOfNeg % 2 == 0) {
			return product(A, begin, end);
		} else {
			int prevProduct = product(A, begin, lastNegPos);
			int succProduct = product(A, firstNegPos + 1, end);
			return prevProduct > succProduct ? prevProduct : succProduct;
		}
	}

	private int product(int[] A, int begin, int end) {
		int product = 1;
		for (int i = begin; i < end; ++i) {
			product *= A[i];
		}
		return product;
	}

}
