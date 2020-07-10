package site.ibit.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    public static int lis(final List<Integer> A) {
        int n = A.size();
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));//ans = 6
        lis(arrayList);
    }

}
