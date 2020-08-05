package site.interview.dunjo;

import java.util.Arrays;

public class CoinAndEnergy2 {

    public static void main(String[] args) {
        //input 1
        int[] coin = {3, 23, 9, 2, 2};
        int[] energy = {1, 5, 3, 3, 1};
        int initail_energy = 1;
        int ans = maxCoins2(coin,energy,initail_energy); // ans = 32

        //input 2
        int[] coin2 = {11, 5, 7};
        int[] energy2 = {2, 1, 1};
        initail_energy = 0;
        ans = maxCoins2(coin2,energy2,initail_energy); //ans = 12

        //input 3
        int[] coin3 = {5, 5, 5};
        int[] energy3 = {12, 2, 2};
        initail_energy = 1999;
        ans = maxCoins2(coin3,energy3,initail_energy); //ans = 15

        System.out.println();
    }

    //DP problem - 2D dp similar to knapsack.

    //O(n^2) time and O(n) memory, for each position determine the maximal possible number of coins
    // for each energy value, of course if energy>n then we can lower this to n,
    // because in that case we can pick all (remaining) coins.
    public static int maxCoins(int[] coin, int[] energy, int initial_energy) {
        int n = coin.length;
        if (n == 0 || initial_energy < 0) return 0;
        int[]dp  = new int[n+1]; //energy
        Arrays.fill(dp,-1);

        int c = coin[0];
        int e = energy[0];

        // pick coin
        dp[Math.min(n, initial_energy)] = c;

        // pick energy
        int energy2 = Math.min(n, initial_energy + e);
        dp[energy2] = Math.max(dp[energy2], 0);

        int ans = c;

        for (int i = 1; i < n; i++) {
            int[]T  = new int[n+1];
            Arrays.fill(T,-1);
            c = coin[i];
            e = energy[i];

            for (int my_energy = 1; my_energy <= n; my_energy++) {
                if (dp[my_energy] == -1) continue;
                // pick coin
                int coin2 = dp[my_energy] + c;
                T[my_energy - 1] = Math.max(T[my_energy - 1], coin2);
                ans = Math.max(ans, coin2);
                // pick energy
                energy2 = Math.min(n, my_energy - 1 + e);
                T[energy2] = Math.max(T[energy2], dp[my_energy]);
            }
            dp = T;
        }
        return ans;
    }

    //buggy, doesnot pass the third case
    private static int maxCoins2( int[] coins, int[] energy,int init) {
        int eSum = 0;
        for(int e : energy) {
            eSum += e;
        }
        int[][] dp = new int[coins.length][eSum + 1];
        for(int i=dp.length - 1;i>=0;i--) {
            for(int j=0;j<=coins.length;j++) {
                if(i == dp.length - 1) {
                    dp[i][j] = coins[i];
                    continue;
                }
                dp[i][j] = dp[i+1][Math.min(coins.length, j + energy[i] - 1)];
                if(j > 0) {
                    dp[i][j] = Math.max(dp[i][j], coins[i] + dp[i+1][j-1]);
                }else if(j == 0) {
                    dp[i][j] = Math.max(dp[i][j], coins[i]);
                }
            }
        }
        return dp[0][Math.min(dp[0].length, init)];
    }
}
