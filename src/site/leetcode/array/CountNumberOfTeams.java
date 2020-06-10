package site.leetcode.array;

//https://leetcode.com/problems/count-number-of-teams/
public class CountNumberOfTeams {

    //Time complexity is O(n ^ 3)
    public int numTeams(int[] rating) {
        int n = rating.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int g = j + 1; g < n; g++) {
                    if (rating[i] < rating[j] && rating[j] < rating[g]
                            || rating[i] > rating[j] && rating[j] > rating[g]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    //Time complexity is O(n ^ 2)
    public int numTeams2(int[] rating) {
        int n = rating.length;
        int answer = 0;

        int[] numberOfBiggerFromLeft = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] > rating[i]) {
                    numberOfBiggerFromLeft[i]++;
                }
            }
        }

        int[] numberOfBiggerFromRight = new int[n];
        for (int i = 0; i + 1 < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) {
                    numberOfBiggerFromRight[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int rightToLeft = numberOfBiggerFromLeft[i] * (n - 1 - i - numberOfBiggerFromRight[i]);
            int leftToRight = (i - numberOfBiggerFromLeft[i]) * numberOfBiggerFromRight[i];
            answer += rightToLeft + leftToRight;
        }

        return answer;
    }

}
