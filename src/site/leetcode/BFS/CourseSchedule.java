package site.leetcode.BFS;

import org.junit.experimental.max.CouldNotReadCoreException;

import java.util.*;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites1 = {{1,0}};
        int[][] prerequisites2 = {{1,0},{0,1}};
        boolean ans = canFinish(numCourses, prerequisites2);
        System.out.println(ans);
    }

    //BFS with indegree
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

    // //topological sort
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
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
        while (!stack.isEmpty()) {
            int poped_info = stack.pop();

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
        return count == numCourses;
    }

    class VisitConstant {
        public static final int unvisited = 0;
        public static final int partiallyVisited = 1;
        public static final int fullyVisited = 2;
    }

    //DFS
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        VisitConstant visitConstant = new VisitConstant();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visited[i] = visitConstant.unvisited;
        }

        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            if (graph.containsKey(curr[0])) {
                graph.get(curr[0]).add(curr[1]);
            } else {
                LinkedList<Integer> dependencyList = new LinkedList<>();
                dependencyList.add(curr[1]);
                graph.put(curr[0], dependencyList);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == visitConstant.unvisited) {
                boolean temp = dfs(i, graph, visited, visitConstant);
                if (!temp) {
                    return false;
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == visitConstant.unvisited) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, HashMap<Integer, LinkedList<Integer>> graph, int[] visited, VisitConstant visitConstant) {
        if (visited[node] == visitConstant.partiallyVisited) {
            return false;
        }

        visited[node] = visitConstant.partiallyVisited;
        boolean res = true;

        LinkedList<Integer> dependencyList = graph.get(node);
        if (dependencyList == null) {
            visited[node] = visitConstant.fullyVisited;
            return true;
        } else {
            for (int k = 0; k < dependencyList.size(); k++) {
                res = res && dfs(dependencyList.get(k), graph, visited, visitConstant);
            }
        }

        visited[node] = visitConstant.fullyVisited;
        return res;
    }
}
