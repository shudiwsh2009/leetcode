package com.ise.shudi.leetcode149.max.points.on.a.line;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[2];
		points[0] = new Point(0, 0);
		points[1] = new Point(0, 0);
		MaxPointsOnALine mp = new MaxPointsOnALine();
		System.out.println(mp.maxPoints(points));
	}

	public int maxPoints(Point[] points) {
		if (points.length == 0) {
			return 0;
		}
		int max = 1;
		for (int i = 0; i < points.length; ++i) {
			Map<String, Integer> kMap = new HashMap<String, Integer>();
			int subMax = 0;
			int coincide = 0;
			for (int j = 0; j < points.length; ++j) {
				if (i == j) {
					continue;
				} else if (points[i].x == points[j].x
						&& points[i].y == points[j].y) {
					++coincide;
					continue;
				}
				String k = normalize(points[i], points[j]);
				if (!kMap.containsKey(k)) {
					kMap.put(k, 1);
				} else {
					kMap.put(k, kMap.get(k) + 1);
				}
				if (kMap.get(k) > subMax) {
					subMax = kMap.get(k);
				}
			}
			if (subMax + coincide + 1 > max) {
				max = subMax + coincide + 1;
			}
		}
		return max;
	}

	private String normalize(Point a, Point b) {
		if (a.x == b.x) {
			return "INFINITY";
		} else if (a.y == b.y) {
			return "ZERO";
		} else {
			int denominator = a.x - b.x;
			int nominator = a.y - b.y;
			int gcd = gcd(denominator, nominator);
			denominator /= gcd;
			nominator /= gcd;
			return denominator + "/" + nominator;
		}
	}

	private int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}