package site.leetcode.BFS;

import java.util.*;

//https://leetcode.com/problems/course-schedule-iv/
public class CourseSchedulesIV {

    private static List<List<Integer>> adjGraph = new ArrayList<>();
    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        // Add n nodes
        for(int i =0 ;i< n ;i++) {
            adjGraph.add(new ArrayList<>());
        }
        // Add edges to the graph
        for (int i = 0; i < prerequisites.length; i++) {
            adjGraph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i =0;i< queries.length ;i++) {
            boolean pre = false;
            if(bfs(adjGraph, queries[i][0], queries[i][1])) {
                pre = true;
            }
            res.add(pre);
        }
        return res;
    }

    private static boolean bfs(List<List<Integer>> adjGraph, int source, int destination) {
        boolean visited[] = new boolean[adjGraph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = Boolean.TRUE;
        while(!q.isEmpty()) {
            Integer cur = q.poll();
            for(Integer child: adjGraph.get(cur)) {
                if(child == destination) {
                    return true;
                }
                if (!visited[child]) {
                    q.add(child);
                    visited[child] = true;
                }
            }
        }
        return false;
    }

    //Topological Sorting
    public static List<Boolean> checkIfPrerequisite2(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> out = new ArrayList<>();
        if(prerequisites.length==0){
            for(int k=0;k<queries.length;k++) {
                out.add(false);
            }
            return out;
        }
        List<Integer>adj[] = new ArrayList[n];
        for(int i=0;i<n;i++) {
            adj[i] = new ArrayList<>();
        }
        for(int k=0;k<prerequisites.length;k++) {
            adj[prerequisites[k][0]].add(prerequisites[k][1]);
        }
        Map<Integer, List<Integer>> topo = topologicalSort(adj,n);
        for(int k=0;k<queries.length;k++) {
            if(topo.get(queries[k][1]).contains(queries[k][0])) {
                out.add(true);
            }else {
                out.add(false);
            }
        }
        return out;
    }

    public static Map<Integer, List<Integer>> topologicalSort(List<Integer>adj[],int n) {
        boolean visited[] = new boolean[n];
        Stack<Integer> s1 = new Stack<>();
        for(int i=0;i<n;i++) {
            if(visited[i]==false) {
                topologicalSortUtil(adj,s1,visited,i);
            }
        }
        Map<Integer, List<Integer>> hs = new HashMap<>();
        List<Integer>temp = new ArrayList<>();
        while(s1.size()>0) {
            int data = s1.pop();
            System.out.print(data + "->");
            temp.add(data);
            List<Integer>temp2 = new ArrayList<>();
            temp2.addAll(temp);
            hs.put(data, temp2);
        }
        return hs;

    }
    public static void topologicalSortUtil(List<Integer>adj[],Stack<Integer> s1,boolean visited[],int dest) {
        visited[dest]= true;
        Iterator<Integer> itr = adj[dest].iterator();
        while(itr.hasNext()) {
            Integer elem = itr.next();
            if(visited[elem]==false) {
                topologicalSortUtil(adj,s1,visited,elem);
            }
        }
        s1.push(dest);
    }

    //Floyd Warshall
    public static List<Boolean> checkIfPrerequisite3(int n, int[][] pre, int[][] queries) {
        long[][] dist = new long[n + 1][n + 1];
        for(int i = 0; i <= n ; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i <= n; i++) {
            dist[i][i] = 0;
        }
        for(int i = 0; i < pre.length; i++) {
            int from = pre[i][0];
            int to = pre[i][1];
            dist[from][to] = 1;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {

                    if(dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for(int i = 0;i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if(dist[a][b] != Integer.MAX_VALUE) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int prerequisites[][] = {{2,3},{2,1},{0,3},{0,1}};
        int queries[][] = {{0,1},{0,3},{2,3},{3,0},{2,0},{0,2}};
        int n = 4;
        checkIfPrerequisite2(n,prerequisites,queries);

    }
}
