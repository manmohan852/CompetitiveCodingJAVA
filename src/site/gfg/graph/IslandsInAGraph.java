package site.gfg.graph;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/number-of-islands/
//https://www.geeksforgeeks.org/islands-in-a-graph-using-bfs/
public class IslandsInAGraph {
    static final int R = 5;
    static final int C = 5;

    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean isSafe(int mat[][], int i, int j,
                          boolean vis[][]) {
        return (i >= 0) && (i < R) &&
                (j >= 0) && (j < C) &&
                (mat[i][j] == 1 && !vis[i][j]);
    }

    //O(V + E) where V is number of vertices and E is number of edges
    static void BFS(int mat[][], boolean vis[][], int si, int sj) {
        int row[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int col[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(si, sj));
        vis[si][sj] = true;

        while (!q.isEmpty()) {
            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();

            for (int k = 0; k < 8; k++) {
                if (isSafe(mat, i + row[k],
                        j + col[k], vis)) {
                    vis[i + row[k]][j + col[k]] = true;
                    q.add(new pair(i + row[k], j + col[k]));
                }
            }
        }
    }

    //Time complexity: O(ROW x COL)
    static void DFS(int M[][], int row, int col, boolean visited[][]) {
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    static int countIslands(int mat[][]) {
        boolean[][] vis = new boolean[R][C];

        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    BFS(mat, vis, i, j);
//                    DFS(mat,i,j,vis);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.print(countIslands(mat));
    }
}

