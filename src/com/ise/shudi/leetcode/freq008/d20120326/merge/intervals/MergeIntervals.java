package com.ise.shudi.leetcode.freq008.d20120326.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		MergeIntervals mi = new MergeIntervals();
		List<Interval> result = mi.merge(intervals);
		for(Interval i : result) {
			System.out.print("[" + i.start + "," + i.end + "] ");
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval in1, Interval in2) {
				return in1.start - in2.start;
			}
		});
        for(int i = 0; i < intervals.size() - 1; ++i) {
        	Interval vi = intervals.get(i);
        	Interval vj = intervals.get(i + 1);
        	if(vi.end < vj.start) {
        		continue;
        	}
        	vi.end = Math.max(vi.end, vj.end);
        	intervals.remove(i + 1);
        	--i;
        }
        return intervals;
    }

}

class Interval {
	int start;
	int end;
	
	public Interval() {
		start = 0;
		end = 0;
	}
	
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}
