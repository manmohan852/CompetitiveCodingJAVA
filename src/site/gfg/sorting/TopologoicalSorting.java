package site.gfg.sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
//https://www.geeksforgeeks.org/topological-sorting/
//The above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is O(V+E).
public class TopologoicalSorting {
    static class Graph {
        private int V;
        private ArrayList<ArrayList<Integer>> adj;

        Graph(int v) {
            V = v;
            adj = new ArrayList<ArrayList<Integer>>(v);
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<Integer>());
        }

        void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        //DFS
        void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
            visited[v] = true;
            Integer i;
            Iterator<Integer> it = adj.get(v).iterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);
            }
            stack.push(v);
        }

        void topologicalSort() {
            Stack<Integer> stack = new Stack<Integer>();

            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            while (stack.empty() == false)
                System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
