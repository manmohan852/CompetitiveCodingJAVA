package site.gfg.dp;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-cost-to-reach-end-of-array-array-when-a-maximum-jump-of-k-index-is-allowed/
public class MinCostToReachEndOfArray {

    //Time Complexity: O(N * K)
    static int FindMinimumCost(int ind, int a[], int n, int k, int dp[]) {
        if (ind == (n - 1))
            return 0;
        else if (dp[ind] != -1)
            return dp[ind];
        else {
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                if (ind + i < n)
                    ans = Math.min(ans, Math.abs(a[ind + i] - a[ind]) + FindMinimumCost(ind + i, a, n, k, dp));
                else
                    break;
            }
            return dp[ind] = ans;
        }
    }

    //Time Complexity: O(N * K)
    static int minCostJumpsDP(int[] A, int k) {
        int size = A.length;
        int[] x = new int[size];
        Arrays.fill(x, Integer.MAX_VALUE);
        x[0] = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < i + k + 1 && j < size; j++) {
                x[j] = Math.min(x[j], x[i] + Math.abs(A[i] - A[j]));
            }
        }
        return x[size - 1];
    }

    public static void main(String[] args) {
        int a[] = {10, 30, 40, 50, 20};
        int k = 3;
        int n = a.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(FindMinimumCost(0, a, n, k, dp));
    }
}

