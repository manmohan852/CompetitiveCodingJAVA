package site.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//http://happycoding2010.blogspot.com/2015/11/leetcode-253-meeting-rooms-ii.html
public class MeetingRooms2 {

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

//    Sorting takes O(nlogn).
//    \Offering to min heap takes O(logn) so the for loop takes O(nlogn).
//    The overall time complexity is O(nlogn).
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();// y default it is a min heap.
//        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder()); // max heap
        minHeap.add(intervals[0].end);
        for (int i = 1; i < intervals.length; ++i) {
            if (minHeap.peek() <= intervals[i].start) minHeap.poll();
            minHeap.add(intervals[i].end);
        }
        return minHeap.size();
    }


    //O(nlogn) solution, but fast than solution 1.
    public int minMeetingRooms2(Interval[] intervals) {
        int n=intervals.length;
        int[] start=new int[n];
        int[] end=new int[n];
        for (int i=0; i<n; i++) {
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0, j=0, res=0;
        while (i<n) {
            if (start[i]<end[j]) i++;
            else if (start[i]>end[j]) j++;
            else {
                i++;
                j++;
            }
            res=Math.max(res,i-j);
        }
        return res;
    }
}
