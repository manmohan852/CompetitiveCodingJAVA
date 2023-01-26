package MySite.LeetCode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites1 = {{1,0}};
        int[][] prerequisites2 = {{1,0},{0,1}};
        boolean ans = canFinish(numCourses, prerequisites2);
        System.out.println(ans);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        int[] indegree = new int[numCourses];
        for (int[] e : prerequisites) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        //  Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int c : graph[current]) {
                indegree[c]--;
                if (indegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }
        return numCourses == 0;
    }
}
