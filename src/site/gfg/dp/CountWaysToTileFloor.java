package site.gfg.dp;

//https://www.geeksforgeeks.org/count-number-ways-tile-floor-size-n-x-m-using-1-x-m-size-tiles/
public class CountWaysToTileFloor {

//    Time Complexity: O(n)
    static int countWays(int n, int m) {
        int count[] = new int[n + 1];
        count[0] = 0;
        int i;
        for (i = 1; i <= n; i++) {
            if (i > m)
                count[i] = count[i - 1] + count[i - m];
            else if (i < m || i == 1)
                count[i] = 1;
            else
                count[i] = 2; // i = = m
        }
        return count[n];
    }

    public static void main(String[] args) {
        int n = 7;
        int m = 4;
        System.out.println("Number of ways = "
                + countWays(n, m));
    }
}

