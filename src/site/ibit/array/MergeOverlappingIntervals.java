package site.ibit.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

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

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        ArrayList<Interval> res = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(intervals.get(i).end, end);
            } else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();

        // sort list by interval's start time in ascending,
        // if start time are equal, then sort by end time in ascending order.
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i + 1);
            if (i1.end < i2.start) {
                // i1 goes completely before i2
                result.add(i1);
            } else {
                // overlapping, then merge these two intervals
                i1.start = Math.min(i1.start, i2.start);
                i1.end = Math.max(i1.end, i2.end);
                intervals.remove(i + 1);
                i--;
            }
        }
        // don't forget to add the last interval which is the merging interval
        result.add(intervals.get(intervals.size() - 1));
        return result;
    }

    public ArrayList<Interval> merge3(ArrayList<Interval> intervals) {
        if (intervals == null) return null;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        ArrayList<Interval> merged = new ArrayList<>();
        for (Interval current : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() -1).end < current.start) {
                merged.add(current);
            } else {
                merged.get(merged.size() -1).end = Math.max(current.end,
                        merged.get(merged.size() -1).end);
            }
        }
        return merged;
    }
}
