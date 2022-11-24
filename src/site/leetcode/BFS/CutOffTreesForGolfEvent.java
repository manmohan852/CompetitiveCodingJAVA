package site.leetcode.BFS;

import java.util.*;
//https://leetcode.com/problems/cut-off-trees-for-golf-event/
//        675. Cut Off Trees for Golf Event
public class CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest.get(0).get(0) == 0) return -1;
        List<Integer> height = new ArrayList<>();
        HashMap<Integer, Cell> map = new HashMap();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                if (forest.get(i).get(j) > 1) {
                    height.add(forest.get(i).get(j));
                    map.put(forest.get(i).get(j), new Cell(i, j));
                }
            }
        }
        Collections.sort(height);
        int index = 0;
        int count = height.size();
        Cell curr = new Cell(0, 0);
        int res = 0;
        while (count > 0) {
            Cell destination = map.get(height.get(index));
            int distance = bfs(curr, destination, forest);
            if (distance == -1) return -1;
            res += distance;
            curr = destination;
            index++;
            count--;
        }
        return res;
    }

    public int bfs(Cell curr, Cell destination, List<List<Integer>> forest) {
        boolean[][] seen = new boolean[forest.size()][forest.get(0).size()];
        int[][] path = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Cell> q = new LinkedList();
        q.offer(curr);
        seen[curr.x][curr.y] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Cell node = q.poll();
                size--;
                if (node.match(destination)) return level;
                for (int[] p : path) {
                    int nextX = node.x + p[0];
                    int nextY = node.y + p[1];
                    if (valid(nextX, nextY, forest) && !seen[nextX][nextY]) {
                        q.offer(new Cell(nextX, nextY));
                        seen[nextX][nextY] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public boolean valid(int x, int y, List<List<Integer>> forest) {
        int r = forest.size();
        int c = forest.get(0).size();
        if (x < 0 || y < 0 || x >= r || y >= c) return false;
        else if (forest.get(x).get(y) == 0) return false;
        else {
            return true;
        }
    }
}

class Cell {
    public int x;
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean match(Cell other) {
        return this.x == other.x && this.y == other.y;
    }
}