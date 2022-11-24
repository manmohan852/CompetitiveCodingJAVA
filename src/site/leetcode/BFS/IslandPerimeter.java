package site.leetcode.BFS;
//https://leetcode.com/problems/island-perimeter/
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] == 0) {
                            perimeter++;
                        }
                    } else {
                        perimeter++;
                    }
                    if (i + 1 < m) {
                        if (grid[i + 1][j] == 0) {
                            perimeter++;
                        }
                    } else {
                        perimeter++;
                    }
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] == 0) {
                            perimeter++;
                        }
                    } else {
                        perimeter++;
                    }
                    if (j + 1 < n) {
                        if (grid[i][j + 1] == 0) {
                            perimeter++;
                        }
                    } else {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        grid[0] = new int[]{0, 1, 0, 0};
        grid[1] = new int[]{1, 1, 1, 0};
        grid[2] = new int[]{0, 1, 0, 0};
        grid[3] = new int[]{1, 1, 0, 0};

        islandPerimeter(grid);
    }
}
