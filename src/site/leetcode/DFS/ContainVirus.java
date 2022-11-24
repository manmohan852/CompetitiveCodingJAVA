package site.leetcode.DFS;

import java.util.*;

//https://leetcode.com/problems/contain-virus/
//749. Contain Virus
//https://leetcode.com/problems/contain-virus/discuss/526848/Java-DFS-9-ms-Explanation-with-comments
public class ContainVirus {
    public int containVirus(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        while (true) {
            List<Region> regions = new ArrayList<>();
            boolean[][] visited = new boolean[rows][cols];
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (grid[row][col] == 1 && !visited[row][col]) {
                        Region region = new Region();
                        dfs(grid, row, col, visited, region);
                        if (region.uninfectedNeighbors.size() > 0) {
                            regions.add(region);
                        }
                    }
                }
            }
            if (regions.size() == 0) {
                break;
            }
            regions.sort(new Comparator<Region>() {
                @Override
                public int compare(Region o1, Region o2) {
                    return o2.uninfectedNeighbors.size() - o1.uninfectedNeighbors.size();
                }
            });
            Region regionThatCauseMostInfection = regions.remove(0);
            result += regionThatCauseMostInfection.wallsRequired;
            for (int neighbor : regionThatCauseMostInfection.infected) {
                int row = neighbor / cols;
                int col = neighbor % cols;
                grid[row][col] = 2;
            }
            for (Region region : regions) {
                for (int neighbor : region.uninfectedNeighbors) {
                    int row = neighbor / cols;
                    int col = neighbor % cols;
                    grid[row][col] = 1;
                }
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, Region region) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 2) {
            return;
        }
        if (grid[row][col] == 1) {
            region.infected.add(row * cols + col);
            if (visited[row][col]) {
                return;
            }
        }
        visited[row][col] = true;
        if (grid[row][col] == 0) {
            region.wallsRequired++;
            region.uninfectedNeighbors.add(row * cols + col);
            return;
        }
        dfs(grid, row + 1, col, visited, region);
        dfs(grid, row - 1, col, visited, region);
        dfs(grid, row, col + 1, visited, region);
        dfs(grid, row, col - 1, visited, region);
    }
}

class Region {
    Set<Integer> infected = new HashSet<>();
    Set<Integer> uninfectedNeighbors = new HashSet<>();
    int wallsRequired = 0;
}