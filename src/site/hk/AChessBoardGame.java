package site.hk;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AChessBoardGame {

    static int DP[][];
    static int dx[] = {-2, -2, 1, -1};
    static int dy[] = {1, -1, -2, -2};

    static void initDP() {
        DP = new int[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                DP[i][j] = -1;
            }
        }
        DP[0][0] = 0;
        DP[0][1] = 0;
        DP[1][0] = 0;
        DP[1][1] = 0;
    }

    static String chessboardGame(int x, int y) {
        if (dp(x, y) == 0) {
            return "Second";
        }
        return "First";
    }

    public static int dp(int x, int y) {
        if(x<0 || y<0 || x>=15 || y>=15)return -1;
        if(DP[x][y]!=-1)return DP[x][y];

        if (dp(x - 2, y + 1) == 0 | dp(x - 2, y - 1) == 0 | dp(x + 1, y - 2) == 0 | dp(x - 1, y - 2) == 0) {
            DP[x][y] = 1;
        } else DP[x][y] = 0;
        return DP[x][y];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initDP();
        int x = 5;
        int y = 2;
        String result = chessboardGame(x - 1, y - 1);
        System.out.println(result);
    }
}

