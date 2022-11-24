package site.interview;

import java.util.ArrayList;
import java.util.List;

//ques:
//i/p = [[1,2,6],[5,3,8],[9,4,5]]     n * m matrix
//        o/p = True → [1,2,3,4,5]
//        o/p = False
//        Path → [0,0] → [n-1,m-1] and diff between prev and next is equal

public class DiffBetweenPrevAndNextElementIsSame {

    static int[][] arr;
    static int[][] diffM;
    static boolean[][] valid;
    static int m;
    static int n;
    static List<Integer> res;

    //O(m*n)
    static public boolean isPathPossible(int[][] arr) {
        diffM = new int[m][n];
        valid = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valid[i][j] = false;
            }
        }
        valid[0][0] = true;
        for (int i = 1; i < m; i++) {
            diffM[0][i] = arr[0][i] - arr[0][i - 1];
            if (i == 1) valid[0][i] = true;
            else if (diffM[0][i] == diffM[0][i - 1]) valid[0][i] = true;
            else valid[0][i] = false;
        }
        for (int i = 1; i < n; i++) {
            diffM[i][0] = arr[i][0] - arr[i - 1][0];
            if (i == 1) valid[i][0] = true;
            else if (diffM[i][0] == diffM[i - 1][0]) valid[i][0] = true;
            else valid[i][0] = false;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (valid[i - 1][j] == true && arr[i][j] - arr[i - 1][j] == diffM[i - 1][j]) {
                    diffM[i][j] = diffM[i - 1][j];
                    valid[i][j] = true;
                } else if (valid[i][j - 1] == true && arr[i][j] - arr[i][j - 1] == diffM[i][j - 1]) {
                    diffM[i][j] = diffM[i][j - 1];
                    valid[i][j] = true;
                } else
                    valid[i][j] = false;
            }
        }
        return valid[m - 1][n - 1];
    }

    static boolean isSafe(int i, int j) {
        if (i >= 0 && j >= 0 && valid[i][j]) {
            return true;
        }
        return false;
    }

    static public void printPathUtil(int i, int j) {
        if (isSafe(i - 1, j) && diffM[i][j] == diffM[i - 1][j]) {
            printPathUtil(i - 1, j);
        } else if (isSafe(i, j - 1) && diffM[i][j] == diffM[i][j - 1]) {
            printPathUtil(i, j - 1);
        }
        res.add(arr[i][j]);
    }

    static public void printPath2(int i, int j) {
        res = new ArrayList<>();
        if (isSafe(i, j)) {
            res.add(arr[0][0]);
            printPathUtil(i, j);
        }
    }


    public static void main(String[] args) {
        try {
            arr = new int[][]{{1, 2, 6}, {5, 3, 8}, {9, 4, 5}};
            m = 3;
            n = 3;
            if(isPathPossible(arr)){
                System.out.println("TRUE");
                printPath2(m - 1, n - 1);
                for (int i = 0; i < res.size(); i++) {
                    System.out.print(res.get(i) + " ");
                }
            }
            else {
                System.out.println("FALSE");
            }

            System.out.println();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            e.printStackTrace();

        }

    }

}
