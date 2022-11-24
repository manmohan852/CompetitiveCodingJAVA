package site.interview.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
//https://leetcode.com/articles/introduction-to-n-ary-trees/
//https://medium.com/@sahilawasthi9560460170/lowest-common-ancestor-of-n-ary-tree-107fa772a939
//https://www.geeksforgeeks.org/lca-for-general-or-n-ary-trees-sparse-matrix-dp-approach-onlogn-ologn/
//// Sparse Matrix DP approach to find LCA of two nodes
public class CommonAncestorOfNaryTree3 {

    static final int MAXN = 100000;
    static final int level = 18;

    static List<Integer>[] tree = new ArrayList[MAXN];
    static int[] depth = new int[MAXN];
    static int[][] parent = new int[MAXN][level];

    // pre-compute the depth for each node and their
    // first parent(2^0th parent)
    // time complexity : O(n)
    static void dfs(int cur, int prev) {
        depth[cur] = depth[prev] + 1;
        parent[cur][0] = prev;
        for (int i = 0; i < tree[cur].size(); i++) {
            if (tree[cur].get(i) != prev) {
                dfs(tree[cur].get(i), cur);
            }
        }
    }

    // Dynamic Programming Sparse Matrix Approach
    // populating 2^i parent for each node
    // Time complexity : O(nlogn)
    static void precomputeSparseMatrix(int n) {
        for (int i = 1; i < level; i++) {
            for (int node = 1; node <= n; node++) {
                if (parent[node][i - 1] != -1)
                    parent[node][i] = parent[parent[node][i - 1]][i - 1];
            }
        }
    }

    // Returning the LCA of u and v
    // Time complexity : O(log n)
    static int lca(int u, int v) {
        if (depth[v] < depth[u]) {
            u = u + v;
            v = u - v;
            u = u - v;
        }

        int diff = depth[v] - depth[u];

        // Step 1 of the pseudocode
        for (int i = 0; i < level; i++)
            if (((diff >> i) & 1) == 1)
                v = parent[v][i];

        // now depth[u] == depth[v]
        if (u == v)
            return u;

        // Step 2 of the pseudocode
        for (int i = level - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }

    static void addEdge(int u, int v) {
        tree[u].add(v);
        tree[v].add(u);
    }

    static void memset(int value) {
        for (int i = 0; i < MAXN; i++) {
            for (int j = 0; j < level; j++) {
                parent[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        memset(-1);
        for (int i = 0; i < MAXN; i++)
            tree[i] = new Vector<>();
        int n = 8;
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(2, 6);
        addEdge(3, 7);
        addEdge(3, 8);
        depth[0] = 0;

        // running dfs and precalculating depth
        // of each node.
        dfs(1, 0);

        // Precomputing the 2^i th ancestor for evey node
        precomputeSparseMatrix(n);

        // calling the LCA function
        System.out.print("LCA(4, 7) = " + lca(4, 7) + "\n");
        System.out.print("LCA(4, 6) = " + lca(4, 6) + "\n");
    }
}