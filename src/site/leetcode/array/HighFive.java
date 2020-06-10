package site.leetcode.array;

import java.util.Arrays;

//https://leetcode.com/problems/high-five/
public class HighFive {

    public static int[][] highFive(int[][] items) {
        // top 5 scores of every student's,
        // then get the average.
        // first sort items[i][0], then sort items[i][1].
        // [0]: ascending  [1]: descending
        Arrays.sort(items, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int count = 0;
        int id = 0;
        int index = 0;
        int[][] res = new int[items.length][2];
        for (int i = 0; i < items.length; i++) {
            if (items[i][0] != id) {
                id = items[i][0];
                res[index][0] = id;
                count = 0;
            }
            if (count < 5) {
                res[index][1] += items[i][1];
                count++;
                if (count == 5) {
                    res[index][1] /= 5;
                    index++;
                }
            }
        }
        return Arrays.copyOf(res, index);
    }

    public static void main(String[] args) {
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] res = highFive(items);
        for(int i=0;i<res.length;i++){
            for (int j=0;j<res[0].length;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
