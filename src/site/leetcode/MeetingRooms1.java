package site.leetcode;

import java.util.Arrays;
import java.util.Comparator;

//http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms.html
//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
//        determine if a person could attend all meetings.
//        For example,
//        Given [[0, 30],[5, 10],[15, 20]],
//        return false.
public class MeetingRooms1 {

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

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new IntervalComparator());
        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];
            if (isOverlapped(prev, curr)) {
                return false;
            }
            prev = curr;
        }

//        for (int i = 0; i < intervals.length - 1; i++)
//            if (isOverlapped(intervals[i], intervals[i + 1]))
//                return false;
        return true;
    }

    // Sort according to the start time, ascending time
    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    private boolean isOverlapped(Interval a, Interval b) {
        return a.end > b.start;
    }

}
