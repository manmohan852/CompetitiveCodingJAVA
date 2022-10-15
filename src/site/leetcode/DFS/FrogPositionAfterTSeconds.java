package site.leetcode.DFS;

import java.util.*;
import java.util.stream.Collectors;
//https://leetcode.com/problems/frog-position-after-t-seconds/
//1377. Frog Position After T Seconds
public class FrogPositionAfterTSeconds {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] children = new List[n + 1];

        int[] time = new int[n + 1];
        int[] ways = new int[n + 1];
        int[] childCount = new int[n + 1];

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }


        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            childCount[from]++;
            childCount[to]++;
            children[from].add(to);
            children[to].add(from);
        }

        for (int i = 2; i <= n; i++) {
            childCount[i]--;
        }


        Queue<Integer> queue = new LinkedList<>();
        ways[1] = 1;
        time[1] = 0;
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (time[node] > t) break;
            for (int child : children[node]) {
                if (visited[child]) continue;
                ways[child] = ways[node] * childCount[node];
                time[child] = time[node] + 1;
                visited[child] = true;
                queue.add(child);
            }
        }
        if (visited[target] && (time[target] == t || time[target] < t && childCount[target] == 0)) {
            return 1.0 / ways[target];
        } else {
            return 0;
        }
    }

    private double res = 0;
    public double frogPosition2(int n, int[][] edges, int t, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        dfs(1, 1, target, t, map, new boolean[n + 1]);
        return res;
    }
    private void dfs(int curr, double chance, int target, int t, HashMap<Integer, List<Integer>> map, boolean[] visited) {
        visited[curr] = true;
        List<Integer> unvisited = map.get(curr).stream().filter(next -> !visited[next]).collect(Collectors.toList());
        for (int next : unvisited) dfs(next, chance / (double) unvisited.size(), target, t - 1, map, visited);
        if (curr == target && (t == 0 || t > 0 && unvisited.size() == 0)) res = chance;
    }
}
