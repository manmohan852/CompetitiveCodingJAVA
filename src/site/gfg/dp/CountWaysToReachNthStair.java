package site.gfg.dp;

//https://www.geeksforgeeks.org/count-ways-reach-nth-stair/

// Java program to count number of ways to reach n't stair when
// a person can climb 1, 2, ..m stairs at a time
public class CountWaysToReachNthStair {

    //    Time Complexity: O(n).
    int countWays3(int n, int m) {
        int res[] = new int[n+1];
        int temp = 0;
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            int s = i - m - 1;
            int e = i - 1;
            if (s >= 0) {
                temp -= res[s];
            }
            temp += res[e];
            res[i] = temp;
        }
        return res[n];
    }

    static int countWaysUtil2(int n, int m) {
        int res[] = new int[n];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n; i++) {
            res[i] = 0;
            for (int j = 1; j <= m && j <= i; j++)
                res[i] += res[i - j];
        }
        return res[n - 1];
    }

    // Returns number of ways to reach s'th stair
//    Time Complexity: O(m*n).
    static int countWays2(int s, int m) {
        return countWaysUtil(s + 1, m);
    }

    static int countWaysUtil(int n, int m) {
        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += countWaysUtil(n - i, m);
        return res;
    }

    // Returns number of ways to reach s'th stair
    // Time Complexity: O(2^n).
    static int countWays(int s, int m) {
        return countWaysUtil(s + 1, m);
    }


}
