package site.interview.gsachs;

import java.util.Arrays;
import java.util.Comparator;

public class FindTheRank {

    public static int findTheRank(int[][] matrix, int rank) {
        int m = matrix.length;
        int n = matrix[0].length;
        Pair[] totalMarks = new Pair[m];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
            totalMarks[i] = new Pair(i, sum);
        }

        Arrays.sort(totalMarks, new PairComparator());

        Pair rankedPair = totalMarks[rank - 1];
        return rankedPair.index;
    }

    public static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair pair1, Pair pair2) {
            return pair2.totalMarks - pair1.totalMarks;
        }
    }


    public static class Pair {
        int index;
        int totalMarks;

        public Pair(int index, int totalMarks) {
            this.index = index;
            this.totalMarks = totalMarks;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{79, 89, 15}, {85, 89, 92}, {71, 96, 88}};
        System.out.println(findTheRank(matrix, 2));
    }

}
