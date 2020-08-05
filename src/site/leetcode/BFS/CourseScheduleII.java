package site.leetcode.BFS;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {

    //topological sort
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            result[prerequisites[i][0]]++;
        }
        LinkedList<Integer> stack = new LinkedList();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                stack.push(i);
            }
        }
        int count = 0;
        int j = 0;
        int[] answer = new int[numCourses];
        while (!stack.isEmpty()) {
            int poped_info = stack.pop();
            answer[j++] = poped_info;
            count += 1;

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == poped_info) {
                    result[prerequisites[i][0]]--;
                    if (result[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return answer;
        }
        int[] answer2 = {};
        return answer2;
    }

    //BFS with indegree
    public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        int[] indegree = new int[numCourses];
        for (int[] e : prerequisites) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        int[] answer = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        int j = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer[j++] = current;
            for (int c : graph[current]) {
                indegree[c]--;
                if (indegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }

        if (numCourses == 0) {
            int n = answer.length;
            for (int i = 0; i < n / 2; i++) {
                int temp = answer[i];
                answer[i] = answer[n - i - 1];
                answer[n-i-1] = temp;
            }
            return answer;
        }
        int[] answer2 = {};
        return answer2;
    }

    public static void main(String[] args) {
        int noOfCourses = 4;
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        //int[][] pre = {};
        findOrder2(noOfCourses, pre);
    }
}
