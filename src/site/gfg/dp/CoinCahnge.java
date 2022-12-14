package site.gfg.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//https://www.geeksforgeeks.org/coin-change-dp-7/
//how many ways can we make the change?
public class CoinCahnge {

    static int count(int S[], int m, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (m <= 0 && n >= 1)
            return 0;
        return count(S, m - 1, n) +
                count(S, m, n - S[m - 1]);
    }

    //Time Complexity: O(mn)
    static long countWays(int S[], int m, int n) {
        long[] table = new long[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];
        return table[n];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(count(arr, m, 4));
    }
}

