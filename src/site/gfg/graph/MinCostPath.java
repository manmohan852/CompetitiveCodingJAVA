package site.gfg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostPath {

    public static int minCostPath(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight, int x, int y) {
        int V = gNodes;
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < gFrom.size(); i++) {
            graph[gFrom.get(i) - 1][gTo.get(i) - 1] = gWeight.get(i);
            graph[gTo.get(i) - 1][gFrom.get(i) - 1] = gWeight.get(i);
        }
        boolean[] visited = new boolean[V];
        int s = 0;
        int t1 = x - 1;
        int t2 = y - 1;
        int t = gNodes - 1;
        int ans = 0;
        ans += minimumCostSimplePath(s, t1, visited, graph, V);
        ans += minimumCostSimplePath(t1, t2, visited, graph, V);
        ans += minimumCostSimplePath(t2, t, visited, graph, V);
        return ans;
    }

    private static int minimumCostSimplePath(int u, int destination, boolean[] visited, int[][] graph, Integer V) {
        if (u == destination)
            return 0;
        visited[u] = true;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            if (graph[u][i] != Integer.MAX_VALUE && !visited[i]) {
                int curr = minimumCostSimplePath(i, destination, visited, graph, V);
                if (curr < Integer.MAX_VALUE) {
                    ans = Math.min(ans, graph[u][i] + curr);
                }
            }
        }
        visited[u] = false;
        return ans;
    }

    public static void main(String[] args) {
        int gnodes = 4;
        int edges = 5;
        List<Integer> gfrom = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3));
        List<Integer> gTo = new ArrayList<>(Arrays.asList(2, 4, 4, 3, 4));
        List<Integer> gW = new ArrayList<>(Arrays.asList(6, 9, 10, 6, 11));
        int x = 2;
        int y = 3;
        minCostPath(gnodes, gfrom, gTo, gW, x, y);
    }
}
