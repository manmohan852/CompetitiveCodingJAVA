package site.gfg.matrix;

//https://www.geeksforgeeks.org/find-the-largest-rectangle-of-1s-with-swapping-of-columns-allowed/
//Time complexity of above solution is O(R * (R + C))
//Extra space: O(R * C)
public class LargestRectangleOfOne {
    static final int R = 3;
    static final int C = 5;

    static int maxArea(int mat[][]) {
        int hist[][] = new int[R + 1][C + 1];
        for (int i = 0; i < C; i++) {
            hist[0][i] = mat[0][i];
            for (int j = 1; j < R; j++) {
                hist[j][i] = (mat[j][i] == 0) ? 0 : hist[j - 1][i] + 1;
            }
        }
        //counting sort for every row.
        for (int i = 0; i < R; i++) {
            int count[] = new int[R + 1];
            for (int j = 0; j < C; j++) {
                count[hist[i][j]]++;
            }
            int col_no = 0;
            for (int j = R; j >= 0; j--) {
                if (count[j] > 0) {
                    hist[i][col_no] = j;
                    col_no++;
                }
            }
        }
        int curr_area, max_area = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                curr_area = (j + 1) * hist[i][j];
                if (curr_area > max_area) {
                    max_area = curr_area;
                }
            }
        }
        return max_area;
    }

    public static void main(String[] args) {
        int mat[][] = {{0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0}};
        System.out.println("Area of the largest rectangle is " + maxArea(mat));
    }
}

