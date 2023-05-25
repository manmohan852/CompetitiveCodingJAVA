package MySite.LeetCode.graph;

import java.util.LinkedList;
import java.util.Queue;

class FloodFill{
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        boolean[][] visited = new boolean[r][c];
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair (sr, sc));
        visited[sr][sc] = true;
        while(!q.isEmpty()){
            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();
            for(int k = 0; k < 4; k++){
                if(  image[i + row[k]][j + col[k]] == image[sr][sc]   &&
                        (i + row[k] < r) && (i + row[k] >= 0)           &&
                        (j + col[k] < c ) && (j + col[k] >= 0)          &&
                        visited[i + row[k]][j + col[k]] != true    ){
                    image[i + row[k]][j + col[k]] = color;
                    visited[i + row[k]][j + col[k]] = !true;
                    q.add(new Pair(i + row[k], j + col[k]));
                }
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
        return image;
    }

    public static void main(String[] args) {
        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 0, sc = 0, color = 2;
        int ans[][] = floodFill(image, sr, sc, color);
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

    }

}