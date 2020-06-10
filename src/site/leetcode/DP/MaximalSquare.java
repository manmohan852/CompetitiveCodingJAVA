package site.leetcode.DP;

//https://leetcode.com/problems/maximal-square/
//221. Maximal Square
public class MaximalSquare {

    public int maximalSquare(char[][] array) {
        if (array.length == 0)
            return 0;
        int row = array.length;
        int column = array[0].length;
        int result = 0;
        int[][] cache = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = array[i][j] - '0';
                } else if ((array[i][j] - '0') > 0) {
                    cache[i][j] = 1 + Math.min(Math.min(cache[i - 1][j - 1], cache[i - 1][j]), cache[i][j - 1]);
                }
                result = Math.max(result, cache[i][j]);
            }
        }
        return result * result;
    }
}

