package site.byteToByte;

public class MatrixSearch {

    public boolean contains(int[][] arr, int x) {
        if (arr.length == 0 || arr[0].length == 0) return false;
        int row = 0;
        int col = arr.length - 1;

        while (row < arr[0].length && col >= 0) {
            if (arr[row][col] == x) return true;
            if (arr[row][col] < x) row++;
            else col--;
        }

        return false;
    }
}
