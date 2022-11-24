package site.gfg.matrix;

import java.util.*;

public class MinCostPathLeftRightBottomUpMovesAllowed {
    public static class Cell {
        int x;
        int y;
        int dis;

        public Cell(int a, int b, int dis) {
            this.x = a;
            this.y = b;
            this.dis = dis;
        }

        @Override
        public int hashCode() {
            return Integer.parseInt(x+ ":" + y);
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(obj == null || obj.getClass()!= this.getClass())
                return false;
            Cell cell = (Cell) obj;
            return cell.x == this.x && cell.y == this.y;
        }
    }

    public static int mincost(int[][] grid, int m, int n) {
        int dis[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};

        dis[0][0] = grid[0][0];

        Deque<Cell> q = new ArrayDeque<>();

        Cell start = new Cell(0, 0, 0);
        q.add(start);

        while (!q.isEmpty()) {
            Cell temp = q.poll();//head
            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if (!isInsideGrid(x, y, m, n))
                    continue;
                if (dis[x][y] > dis[temp.x][temp.y] + grid[x][y]) {
                    if (dis[x][y] != Integer.MAX_VALUE) {
                        q.remove(new Cell(x, y, dis[x][y]));
                    }
                    dis[x][y] = dis[temp.x][temp.y] + grid[x][y];
                    q.offer(new Cell(x, y, dis[x][y]));//tail
                }
            }
        }
        return dis[m - 1][n - 1];
    }

    private static boolean isInsideGrid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }

    public static void main(String[] args) {
        int grid[][] = {{31, 100, 65, 12, 18},
                {10, 13, 47, 157, 6},
                {100, 113, 174, 11, 33},
                {88, 124, 41, 20, 140},
                {99, 32, 111, 41, 20}};
        mincost(grid, grid.length, grid[0].length);
    }
}
