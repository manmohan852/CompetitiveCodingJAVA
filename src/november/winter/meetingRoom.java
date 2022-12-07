package november.winter;
//https://leetcode.com/problems/meeting-rooms/
// solution - https://leetcode.com/problems/meeting-rooms/solutions/67787/clean-java-solution-with-detailed-explanation/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class meetingRoom {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval e1, Interval e2) {
                return e1.start-e2.start;
            }
        });

        Interval prev = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            Interval current = intervals[i];
            if(prev.end > current.start) return false;
            prev = current;
        }

        return true;
    }
}
