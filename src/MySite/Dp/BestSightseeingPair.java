package MySite.Dp;
// https://leetcode.com/problems/best-sightseeing-pair/
// solution ---- https://leetcode.com/problems/best-sightseeing-pair/solutions/3111413/java-dynamic-programming-with-explanation-and-example/
public class BestSightseeingPair {
    public static void main(String[] args) {

    }
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int left = values[0] + 0, right = 0, maxScore = 0;
        for(int i = 1; i < n; i++){
            right = values[i] - i;
            maxScore = Math.max(maxScore, left + right);
            left = Math.max(left, values[i] + i);
        }
        return maxScore;
    }
}
