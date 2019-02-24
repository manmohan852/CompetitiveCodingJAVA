package site.ibit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {
//    static int[] x = {2,1,-1,-2,-2,-1,1,2};
//    static int[] y = {1,2,2,1,-1,-2,-2,-1};
    static int[] x = {1,1,0,-1,-1,-1,0,1};
    static int[] y = {0,1,1,1,0,-1,-1,-1};
    public static String solve(int A, int B, int C, int D, ArrayList<Integer> E,ArrayList<Integer> F){
        int[][] valid = new int[A+1][B+1];
        int n = C;
        int r = D;
        for(int i=0;i<=A;i++){
            for(int j=0;j<=B;j++){
                for(int z=0;z<n;z++){
                    if(Math.sqrt(Math.pow((E.get(z)-i),2) + Math.pow((F.get(z)-j),2)) <= r){
                        valid[i][j] = -1;
                    }
                }
            }
        }

        if(valid[0][0] == -1 || valid[A][B] == -1)
            return "NO";

        boolean visited[][] = new boolean[A+1][B+1];
        visited[0][0] = true;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        q.add(0);

        while (!q.isEmpty()){
            int i = q.poll();
            int j = q.poll();
            for(int k =0 ;k<8;k++){
                int ix = i + x[k];
                int iy = j + y[k];
                if((ix>=0 && ix<=A && iy >=0 && iy<= B) && !visited[ix][iy] && valid[ix][iy] != -1){
                    if(ix == A && iy == B) return "YES";
                    q.add(ix);q.add(iy);
                    visited[ix][iy] = true;
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        int A= 2;
        int B =3;
        int C=1;
        int D = 1;
        ArrayList<Integer> E = new ArrayList<>();
        E.add(2);
        ArrayList<Integer> F = new ArrayList<>();
        F.add(3);
        System.out.println(solve(A,B,C,D,E,F));
    }
}
