package site.interview.amazon;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//https://leetcode.com/discuss/interview-question/335118/amazon-onsite-find-free-time-for-meetup
//Amazon interviewer has asked me to create my own parser and create an LLD for this question
public class FindFreeTimeForMeetings {
    public static List<String[]> freeSlots(List<String[]> intervals) {
        List<String[]> res = new ArrayList<>();
        List<LocalTime[]> times = new ArrayList<>();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("H:mm");

        // convert to time for simplicity
        for (String[] time : intervals) {
            times.add(new LocalTime[]{LocalTime.parse(time[0], tf), LocalTime.parse(time[1], tf)});
        }

        // sort by start times
        Collections.sort(times, (a, b) -> a[0].compareTo(b[0]));

        // keep most recent as head
        PriorityQueue<LocalTime[]> pq = new PriorityQueue<>((a, b) -> b[1].compareTo(a[1]));

        //merge intervals
        for (LocalTime[] curr : times) {
            if (pq.isEmpty()) {
                pq.offer(curr);
            } else {
                LocalTime[] prev = pq.poll();
                int comp = curr[0].compareTo(prev[1]);
                if (comp < 1) {
                    prev[1] = curr[1].compareTo(prev[1]) > 0 ? curr[1] : prev[1];
                } else {
                    pq.offer(curr);
                }
                pq.offer(prev);
            }
        }

        LocalTime start = LocalTime.of(7, 0);
        LocalTime end = LocalTime.of(18, 0);

        LocalTime[] prev = new LocalTime[]{end, end};
        while (!pq.isEmpty()) {
            LocalTime[] curr = pq.poll();

            // skip if above upper bound
            if (curr[0].compareTo(prev[1]) < 0 && curr[1].compareTo(prev[1]) > 0) {
                prev = curr;
                continue;
            }

            res.add(new String[]{curr[1].toString(), prev[0].toString()});
            prev = curr;
        }

        // if lower bounds is free
        if (prev[0].compareTo(start) > 0) {
            res.add(new String[]{start.toString(), prev[0].toString()});
        }

        return res;
    }

    public static void main(String[] args) {
        String[] int1 = {"16:00", "16:30"};
        String[] int2 = {"6:00", "7:30"};
        String[] int3 = {"8:00", "9:20"};
        String[] int4 = {"8:00", "9:00"};
        String[] int5 = {"17:30", "19:20"};
        List<String[]> list = new ArrayList<>(Arrays.asList(int1,int2,int3,int4,int5));
        freeSlots(list);
    }
}
