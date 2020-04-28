package site.hk;

import java.util.Arrays;
import java.util.Collections;

public class LeaderBoard {
    static int mx = 200000;
    static int s[];
    static int rank[];
    static int a[];

    static void build_rank(int n) {
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                rank[i] = 1;
            } else {
                if (s[i] == s[i - 1]) {
                    rank[i] = rank[i - 1];
                } else {
                    rank[i] = rank[i - 1] + 1;
                }
            }
        }
    }

    static int[] init(int n, int m) {
        int result[]  =new int[m];
        rank = new int[mx + 1];
        build_rank(n);
        int point = n-1;

        for (int j = 0; j < m; j++) {
            int current_rank = 0;
            while (point >= 0 && a[j] > s[point]) {
                point--;
            }
            if (point == -1) {
                current_rank = 1;
            } else if (a[j] == s[point]) {
                current_rank = rank[point];
            } else if (a[j] < s[point]) {
                current_rank = rank[point] + 1;
            }
            result[j] = current_rank;
        }
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        return  result;
    }

    public static void main(String[] args) {
        s = new int[]{100, 100, 50, 40, 40, 20, 10};
        a = new int[]{5,25,50,120};
        init(7,4);
    }
}
