package site.leetcode.BFS;

import java.util.*;

//https://leetcode.com/problems/course-schedule-iii/
public class CourseScheduleIII {

    //Time complexity : O(nlogn)
    //Space complexity : O(n)
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue < Integer > queue = new PriorityQueue < > ((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }
        return queue.size();
    }

    //Time complexity : O(n^2)
    //Space complexity : O(1)
    //-1  indicates that course is not taken
    public static int scheduleCourse2(int[][] courses) {
        System.out.println(courses.length);
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int time = 0, count = 0;
        for (int i = 0; i < courses.length; i++) {
            if (time + courses[i][0] <= courses[i][1]) {
                time += courses[i][0];
                count++;
            } else {
                int max_i = i;
                for (int j = 0; j < i; j++) {
                    if (courses[j][0] > courses[max_i][0])
                        max_i = j;
                }
                if (courses[max_i][0] > courses[i][0]) {
                    time += courses[i][0] - courses[max_i][0];
                }
                courses[max_i][0] = -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};//ans = 3
        int[][] courses2 = {{5, 5}, {4, 6}, {2,6}};
        scheduleCourse(courses2);
    }
}
