package site.ibit.array;

import java.util.ArrayList;
//https://www.interviewbit.com/problems/merge-intervals/
public class MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;
        int i = 0;
        while (i < intervals.size()) {
            Interval in = intervals.get(i);
            if (in.end < current.start) {
                i++;
            } else if (in.start > current.end) {
                intervals.add(i, current);
                break;
            } else {
                current.start = Math.min(in.start, current.start);
                current.end = Math.max(in.end, current.end);
                intervals.remove(i);
            }
        }
        if (i == intervals.size()) {
            intervals.add(current);
        }
        return intervals;
    }

    public static void main(String[] args) {
        //[1,2],[3,5],[6,7],[8,10],[12,16]
    }
}
