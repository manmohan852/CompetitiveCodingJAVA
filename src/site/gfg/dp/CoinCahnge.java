package site.gfg.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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

    //BFS
    //Time complexity: O(N * X)
    static int minNumbers(int[] arr, int n,int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        HashSet<Integer> v = new HashSet<Integer>();
        int d = 0;
        while (q.size() > 0) {
            int s = q.size();
            while (s-- > 0) {
                int c = q.peek();
                if (c == 0)
                    return d;
                q.remove();
                if (v.contains(c) || c < 0)
                    continue;
                v.add(c);
                for (int i = 0; i < n; i++)
                    q.add(c - arr[i]);
            }
            d++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(count(arr, m, 4));
    }
}

