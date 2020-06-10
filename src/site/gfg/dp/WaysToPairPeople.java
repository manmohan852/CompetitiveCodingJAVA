package site.gfg.dp;

//https://www.geeksforgeeks.org/number-of-ways-to-pair-people/
//Time Complexity: O(p)
public class WaysToPairPeople {
    static int findWaysToPair(int p) {
        int dp[] = new int[p + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= p; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[p];
    }

    public static void main(String args[]) {
        int p = 3;
        System.out.println(findWaysToPair(p));
    }
}

