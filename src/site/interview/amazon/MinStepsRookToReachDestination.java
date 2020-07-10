package site.interview.amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinStepsRookToReachDestination {

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    //Time complexity: O(M*N).
    //At worst case, all the cells will be visited.
    public static int countMinStepsRook(int[][] arr, int x, int y, int xx, int yy){
        int m = arr.length;
        int n = arr[0].length;
        if(arr[x][y] == 1){
            return -1;
        }
        if(arr[xx][yy] == 1){
            return -1;
        }
        if(x == xx && y == yy){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(x,y);
        q.add(pair);
        Set<String> pairSet = new HashSet<>();
        pairSet.add(""+pair.x +":"+pair.y);
        int count = 0;
        int countMin = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int nn = q.size();
            for (int i = 0;i < nn;i++){
                Pair temp = q.poll();
                if(temp.x == xx && temp.y == yy){
                    countMin = Math.min(countMin,count);
                }
                int[] dx = {0,0,1,-1};
                int[] dy = {1,-1,0,0};
                for(int j = 0;j<4;j++){
                    int dxx = dx[j];
                    int dyy = dy[j];
                    if(dxx == 0 && dyy == 1){
                        for (int k = temp.y + 1; k<n;k++){
                            int xnew = temp.x;
                            int ynew = k;
                            Pair p = new Pair(xnew,ynew);
                            if(arr[xnew][ynew] == 1){
                                break;
                            }
                            if(!pairSet.contains(""+p.x+":"+p.y)){
                                q.add(p);
                                pairSet.add(""+p.x+":"+p.y);
                            }
                        }
                    }
                    if(dxx == 0 && dyy == -1){
                        for (int k = temp.y - 1; k>=0;k--){
                            int xnew = temp.x;
                            int ynew = k;
                            Pair p = new Pair(xnew,ynew);
                            if(arr[xnew][ynew] == 1){
                                break;
                            }
                            if(!pairSet.contains(""+p.x+":"+p.y)){
                                q.add(p);
                                pairSet.add(""+p.x+":"+p.y);
                            }
                        }
                    }
                    if(dxx == 1 && dyy == 0){
                        for (int k = temp.x + 1; k<m;k++){
                            int xnew = k;
                            int ynew = temp.y;
                            Pair p = new Pair(xnew,ynew);
                            if(arr[xnew][ynew] == 1){
                                break;
                            }
                            if(!pairSet.contains(""+p.x+":"+p.y)){
                                q.add(p);
                                pairSet.add(""+p.x+":"+p.y);
                            }
                        }
                    }
                    if(dxx == -1 && dyy == 0){
                        for (int k = temp.x - 1; k>=0;k--){
                            int xnew = k;
                            int ynew = temp.y;
                            Pair p = new Pair(xnew,ynew);
                            if(arr[xnew][ynew] == 1){
                                break;
                            }
                            if(!pairSet.contains(""+p.x+":"+p.y)){
                                q.add(p);
                                pairSet.add(""+p.x+":"+p.y);
                            }
                        }
                    }
                }
            }
            count++;
        }
        return countMin;
    }
    public static void main(String[] args) {
        int[][] arr = {{0,0,0,0,1},{1,0,1,0,0},{1,0,1,1,0},{1,0,1,1,0},{0,0,0,0,0}};
        countMinStepsRook(arr,0,0,4,0);
    }
}
